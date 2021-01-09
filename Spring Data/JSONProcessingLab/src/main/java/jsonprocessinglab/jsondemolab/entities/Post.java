package jsonprocessinglab.jsondemolab.entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotNull
    @Length(min = 3, max = 80, message = "Title must be between 3 and 80 symbols.")
    private String title;

    @NonNull
    @NotNull
    @Length(min = 3, max = 2048)
    private String content;

    @NonNull
    @NotNull
    @URL
    private String imageUrl;

    @NonNull
    @NotNull
    @Length(min = 3, max = 80, message = "Author must be between 3 and 80 symbols.")
    private String author;

    private LocalDate created = LocalDate.now();
    private LocalDate modified = LocalDate.now();
}
