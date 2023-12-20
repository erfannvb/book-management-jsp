package nvb.dev.bookmanagementjsp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book implements Serializable {

    @JsonIgnore
    private Long id;
    private String bookName;
    private String bookEdition;
    private double bookPrice;

    public Book(String bookName, String bookEdition, double bookPrice) {
        this.bookName = bookName;
        this.bookEdition = bookEdition;
        this.bookPrice = bookPrice;
    }
}
