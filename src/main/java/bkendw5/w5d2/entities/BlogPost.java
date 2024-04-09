package bkendw5.w5d2.entities;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class BlogPost {
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private double lectureTime;
}
