package com.pawa.pawatask.dto;

import com.pawa.pawatask.domain.Priority;

import java.util.List;

public class PriorityListDTO {
    private List<Priority> priorities;

    public PriorityListDTO(List<Priority> priorities) {
        this.priorities = priorities;
    }

    public List<Priority> getPriorities() {
        return priorities;
    }

    public void setPriorities(List<Priority> priorities) {
        this.priorities = priorities;
    }
}
