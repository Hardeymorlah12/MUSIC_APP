package com.Hardeymorlah.Music_App.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;


@Setter
@AllArgsConstructor
@RequiredArgsConstructor
//@Data
@Getter
@Entity
@Table(name = "music", uniqueConstraints = @UniqueConstraint(columnNames = {"title", "year_of_prod"}))
public class Music {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    //@Column(unique = true)
    private String title;
    @NotBlank
    @Length(min = 3, max = 25)
    private String artistName;
    @NotBlank
    @Length(min = 6, max = 25)
    private String albumName;
    @Range(min = 1, max = 6)
    private double musicDuration;
    @NotBlank
    @Length(min = 3)
    private String genre;
    @Min(1900)
    @Max(2024)
    private int yearOfProd;

    @Override
    public String toString() {
        return STR."Music{id=\{id}, title='\{title}\{'\''}, artistName='\{artistName}\{'\''}, albumName='\{albumName}\{'\''}, musicDuration=\{musicDuration}, genre='\{genre}\{'\''}, yearOfProd=\{yearOfProd}\{'}'}";
    }

    ///    @Value("${my.name}")
//     String name;

}
