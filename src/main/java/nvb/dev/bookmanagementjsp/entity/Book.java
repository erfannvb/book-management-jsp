package nvb.dev.bookmanagementjsp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book implements Serializable {

    private Long id;
    private String bookName;
    private String bookEdition;
    private float bookPrice;

    public Book(String bookName, String bookEdition, float bookPrice) {
        this.bookName = bookName;
        this.bookEdition = bookEdition;
        this.bookPrice = bookPrice;
    }
}
