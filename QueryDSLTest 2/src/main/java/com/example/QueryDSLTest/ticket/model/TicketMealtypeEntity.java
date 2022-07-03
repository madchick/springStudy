package com.haksik.haksikapi.ticket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi._comm_.model.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_ticket_mealtype")
@IdClass(TicketMealtypeEntity.class)
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class TicketMealtypeEntity extends BaseTimeEntity implements Serializable {

    @Id
    @Column(name="ticket_id")
    @JsonIgnore
    private Long ticketId;

    @Id
    private MealType mealType;

}
