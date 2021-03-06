package com.spike.community.cache;

import com.spike.community.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<TagDTO> get(){
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("js","php","css","c","c++","c#","java","html","html5","node","node.js","python","golang","ruby","markdown","asp.net","swift","bash","shell","lua","kotlin","perl"));
        tagDTOS.add(program);

        TagDTO framework = new TagDTO();
        framework.setCategoryName("开发框架");
        framework.setTags(Arrays.asList("laravelspring","spring","express","django","flask","yii","ruby-on-rails","tornado","koa","struts"));
        tagDTOS.add(framework);

        TagDTO server = new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("linux","nginx","docker","apache","ubuntu","centos","tomcat","unix","hadoop","windows-server"));
        tagDTOS.add(server);

        TagDTO db= new TagDTO();
        db.setCategoryName("数据库和缓存工具");
        db.setTags(Arrays.asList("mysql","redis","mongodb","sql","oracle","nosql","memcached","sqlserver","postgresql","sqlite"));
        tagDTOS.add(db);

        TagDTO tool= new TagDTO();
        tool.setCategoryName("开发工具");
        tool.setTags(Arrays.asList(
                "git","github","visual-studio-code","vim","sublime-text","xcode","intellij-idea","eclipse","maven","ide","svn","visual-studio","atom","emacs","textmate","hg"));
        tagDTOS.add(tool);

        return tagDTOS;
    }

    public static String filterInValid(String tags){
        String[] split = StringUtils.split(tags,",");
        List<TagDTO> tagDTOS =  get();

        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t ->!tagList.contains(t)).collect(Collectors.joining(","));

        return invalid;
    }
}
