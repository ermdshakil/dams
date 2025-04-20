/*
 * package com.dams.model;
 * 
 * import java.sql.Timestamp;
 * 
 * import jakarta.persistence.CascadeType; import jakarta.persistence.Column;
 * import jakarta.persistence.Entity; import jakarta.persistence.GeneratedValue;
 * import jakarta.persistence.GenerationType; import jakarta.persistence.Id;
 * import jakarta.persistence.JoinColumn; import jakarta.persistence.ManyToOne;
 * import jakarta.persistence.Table; import lombok.AllArgsConstructor; import
 * lombok.Getter; import lombok.NoArgsConstructor; import lombok.Setter;
 * 
 * @Entity
 * 
 * @Getter
 * 
 * @Setter
 * 
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 * 
 * @Table(name="reviews") public class Reviews {
 * 
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * @Column(name= "review_id") private Long reviewId;
 * 
 * @ManyToOne(cascade = CascadeType.PERSIST)
 * 
 * @JoinColumn(name = "patient_id") private Patients patientId;
 * 
 * @ManyToOne(cascade = CascadeType.PERSIST)
 * 
 * @JoinColumn(name = "doctor_id") private Doctors doctorId;
 * 
 * @Column(name= "rating_no") private int rating;
 * 
 * @Column(name= "reviews") private String review_text;
 * 
 * @Column(name= "created_At") private Timestamp createdAt;
 * 
 * }
 */