package Model;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Portfolio {

        @Id
        private String id;
        private String firstName;
        private String lastName;
        private int age;
        private String jobTitle;
        private String email;
        private String skype;
        private String phone;
        private String address;
        private String status;

        @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
        private List<Skill> skills;

        public String getFullName() {
                return firstName + " " + lastName;
        }
}
