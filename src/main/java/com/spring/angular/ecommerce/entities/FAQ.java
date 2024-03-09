package com.spring.angular.ecommerce.entities;

import com.spring.angular.ecommerce.dto.FAQDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FAQ {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String question;
  private String answer;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "product_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Product product;

  public FAQDto getFAQDto() {
    return FAQDto.builder()
        .id(id)
        .question(question)
        .answer(answer)
        .productId(product.getId())
        .build();
  }
}
