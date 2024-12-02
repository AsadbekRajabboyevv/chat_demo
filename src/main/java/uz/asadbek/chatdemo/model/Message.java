package uz.asadbek.chatdemo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String content;
    private String sender;
    private long time;

}
