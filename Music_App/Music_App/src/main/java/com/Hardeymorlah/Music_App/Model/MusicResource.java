package com.Hardeymorlah.Music_App.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
//@Data
@Getter
@Setter
public class MusicResource extends RepresentationModel<MusicResource> {

    private Music music;
}
