package com.java.hospitalmanagementsystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.sql.Timestamp;

/**
 * Represents a payment transaction, including its date and amount. This entity is mapped to the
 * "Payment" table in the database. It records the essential details of financial transactions.
 */
@Data
@Entity
@Table(name = "Payment")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "date", nullable = false)
  private Timestamp date;

  @Positive
  @Column(name = "amount", nullable = false)
  private int amount;

  public Payment() {}

  public Payment(Timestamp date, int amount) {
    this.date = date;
    this.amount = amount;
  }
}
