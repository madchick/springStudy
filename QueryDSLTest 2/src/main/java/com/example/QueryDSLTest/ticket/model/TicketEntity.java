package com.haksik.haksikapi.ticket.model;

import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi._comm_.codeenum.codedata.TicketType;
import com.haksik.haksikapi._comm_.model.BaseTimeEntity;
import com.haksik.haksikapi.menu.model.MenuMealtypeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_ticket")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class TicketEntity extends BaseTimeEntity {

    @Id
    @Column(name="ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    private Long userId;
    private Long orderId;

    private Long schoolId;
    private String schoolName;

    private Long shopId;
    private String shopName;

    private Long menuId;
    private String menuName;
    private String menuPicture;

    private Long itemId;
    private Long itemCount;

    private Long price;

    private MealType mealType;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", foreignKey = @ForeignKey(name="ticket_id"))
    private Set<TicketMealtypeEntity> mealTypes;

    private TicketType ticketType;

    private String ticketDesc;
    private String ticketDetailDesc;

}