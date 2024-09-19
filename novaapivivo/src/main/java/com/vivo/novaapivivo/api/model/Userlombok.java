/* 
package com.vivo.novaapivivo.api.model;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserLombok{
    @Id
    @Getter
    @Setter
    @Table(name = "TB_USER")
    private long idUser;
    @Getter
    @Setter
    private String phoneNumber;
    @Getter
    @Setter
    private String nameUser;

    
    @Getter
    @Setter
    @OneToMany(mappedBy = "user")
    List<ProductModel> product;

    public User(long idUser, String phoneNumber, String nameUser) {
        this.idUser = idUser;
        this.phoneNumber = phoneNumber;
        this.nameUser = nameUser;
    }

}
*/