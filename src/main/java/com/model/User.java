package com.model;

import com.config.annotation.Attribute;
import com.config.annotation.Name;
import com.config.annotation.ObjectType;
import com.config.annotation.Parent;
import java.util.Set;

@ObjectType(2)
@Parent(1)
@Name("User")
public class User extends Entity {
    @Attribute(attrId = 1)
    public String firstname;
    @Attribute(attrId = 2)
    public String lastname;
    @Attribute(attrId = 3)
    public String mail;
    @Attribute(attrId = 4)
    public String phone;
    @Attribute(attrId = 5)
    private Set<Long> reviews;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Set<Long> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Long> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {

        Object[] fields = new Object[]{"Имя : ", firstname, "Фамилия: ", lastname,
                "\nНомер телефона: ", phone, "\nEmail:", mail, };
        StringBuilder s = new StringBuilder();
        for (Object field : fields
        ) {
            s.append(field);
        }
        return s.toString();
    }

}
