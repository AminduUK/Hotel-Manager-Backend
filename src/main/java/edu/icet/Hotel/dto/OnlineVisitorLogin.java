package edu.icet.Hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OnlineVisitorLogin {

    private String usernameOnl;
    private String passwordOnl;

}
