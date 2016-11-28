package org.babypro.domain;

import javax.persistence.*;

/**
 *
 * Bambix : 辅食类
 * Created by apple on 2016/11/15.
 */
@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="food_id")
    private int foodId;

    @Column(name="food_name")
    private String foodName;

    @Column(name="food_message")
    private String foodMessage;


    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, optional = true)
    @JoinColumn(name="user_uid")
    private User user;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int pFoodId) {
        foodId = pFoodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String pFoodName) {
        foodName = pFoodName;
    }

    public String getFoodMessage() {
        return foodMessage;
    }

    public void setFoodMessage(String pFoodMessage) {
        foodMessage = pFoodMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User pUser) {
        user = pUser;
    }
}
