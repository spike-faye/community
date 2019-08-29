package com.spike.community.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class HotTagDTO implements Comparable{
    private String name;
    private Integer priority;
    //优先队列需要对象override一个compareTo方法
    @Override
    public int compareTo(@NotNull Object o) {
        return this.getPriority() - ((HotTagDTO)o).getPriority();
    }
}
