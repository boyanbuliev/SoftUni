package com.example.demo.dtos;

public class DeleteGameDto {
    private long id;

    public DeleteGameDto(long id) {
        this.id = id;
    }

    public DeleteGameDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
