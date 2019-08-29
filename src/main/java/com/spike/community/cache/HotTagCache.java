package com.spike.community.cache;

import com.spike.community.dto.HotTagDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Data
public class HotTagCache {
    private List<String> hots = new ArrayList<>();

    public void updateTags(Map<String,Integer> tags){
        int max = 5;
        PriorityQueue<HotTagDTO> priorityQueue = new PriorityQueue<>(max);
        //循环遍历标签
        tags.forEach((String name, Integer priority) -> {
            HotTagDTO hotTagDTO = new HotTagDTO();
            hotTagDTO.setName(name);
            hotTagDTO.setPriority(priority);
            //标签展示5个，如果不够，加入队列
            if(priorityQueue.size() < max){
                priorityQueue.add(hotTagDTO);
            }else {
                //否则取出权重最小标签，加入新标签
                HotTagDTO minHot = priorityQueue.peek();
                if (hotTagDTO.compareTo(minHot) >= 0) {
                    priorityQueue.poll();
                    priorityQueue.add(hotTagDTO);
                }
            }
        });

        HotTagDTO hotTag = priorityQueue.poll();
        List<String> sortedTags = new ArrayList<>();
        while (hotTag != null){
            sortedTags.add(0,hotTag.getName());
            hotTag = priorityQueue.poll();
        }
        hots = sortedTags;
    }
}
