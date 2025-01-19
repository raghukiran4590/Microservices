package com.cbrk.rating.micro.service.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user_ratings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    private ObjectId id;

    @Field("userId")
    private String userId;

    @Field("hotelId")
    private String hotelId;

    @Field("rating")
    private Integer rating;

    @Field("feedback")
    private String feedback;

}
