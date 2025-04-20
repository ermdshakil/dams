/*
 * package com.dams.repository;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Query; import
 * org.springframework.data.repository.query.Param;
 * 
 * import com.dams.model.Reviews;
 * 
 * public interface ReviewsRepo extends JpaRepository<Reviews, Long>{
 * 
 * @Query("SELECT a FROM Reviews a WHERE a.reviewId = :reviewId")
 * Optional<Reviews> findByReviewId(Long reviewId);
 * 
 * @Query("SELECT a FROM Reviews a WHERE a.patientId = :patientId")
 * List<Reviews> findByPatientsId(@Param("patientId") Long patientId);
 * 
 * @Query("SELECT a FROM Doctors a WHERE a.doctorId = :doctorId") List<Reviews>
 * findByDoctorId(@Param("doctorId") Long doctorId);
 * 
 * 
 * }
 */