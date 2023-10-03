import jakarta.persistence.*;
import org.acme.Number;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "example_table")
public class GreetingEntityJava {


    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "resource_sq", sequenceName = "resource_sq", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resource_sq")
    private Long id;

//    @Type(PostgreSqlStringArrayType.class)
//    @Column(columnDefinition = "text[]")
//    String[] numbers;

    public GreetingEntityJava() {
    }

//    public GreetingEntityJava(String[] numbers) {
//        this.numbers = numbers;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String[] getNumbers() {
//        return numbers;
//    }
//
//    public void setNumbers(String[] numbers) {
//        this.numbers = numbers;
//    }
}