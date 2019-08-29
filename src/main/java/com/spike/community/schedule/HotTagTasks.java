package com.spike.community.schedule;

import com.spike.community.cache.HotTagCache;
import com.spike.community.mapper.QuestionMapper;
import com.spike.community.model.Question;
import com.spike.community.model.QuestionExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class HotTagTasks {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private HotTagCache hotTagCache;

    @Scheduled(cron = "0 0 5 * * *")
    public void hotTagSchedule() {

        int offset = 0;
        int limit = 5;
        log.info("HotTagSchedule start at {}", new Date());
        List<Question> list = new ArrayList<>();
        //priorities记录各个标签及其对应的权重
        Map<String, Integer> priorities = new HashMap<>();
        while (offset == 0 || list.size() == limit) {
            list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, limit));
            for (Question question : list) {
                //将每个问题的标签分离出来
                String[] tags = StringUtils.split(question.getTag(), ",");
                for (String tag : tags) {
                    //得到该标签的权重
                    Integer priority = priorities.get(tag);
                    if (priority != null){
                        priorities.put(tag,priority + 5 + question.getCommentCount());
                    }else{
                        priorities.put(tag,5 + question.getCommentCount());
                    }
                }

                log.info("Questions list : {}", question.getId());
            }

            offset += limit;
        }
        hotTagCache.updateTags(priorities);

        log.info("HotTagSchedule end at {}", new Date());
    }
}
