package rs.ac.bg.fon.pracenjepolaganja.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import rs.ac.bg.fon.pracenjepolaganja.entity.Member;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Represent Data Transfer Object of Student entity.
 * Contains firstname,lastname, index, date of birth and faculty email.
 *
 * @author Vuk Manojlovic
 */
@Data
public class StudentDTO{

    /**
     * Primary key of student entity.
     */
    private Integer id;

    /**
     * Firstname of student.
     * Can't be null or blank.
     */
    @NotBlank(message =  "Firstname is mandatory")
    private String name;

    /**
     * Lastname of student.
     * Can't be null or blank.
     */
    @NotBlank(message = "Lastname is mandatory")
    private String lastname;

    /**
     * Index of student.
     * Must be in form of 0000-0000 where
     * first four digits is first year of study and last four digits
     * are number of index.
     */
    @Pattern(regexp = "[1-9][0-9]{3}-[0-9]{4}",message = "Index is not in valid form")
    private String index;

    /**
     * Date of birth.
     * Date can't be null or be ahead of current date.
     */
    @PastOrPresent(message = "Date can't be ahead of the current date")
    private LocalDate birth;

    /**
     * Faculty email of student.
     * EmailDetails must be in valid form.
     */
    @NotBlank(message = "Name is mandatory")
    @Email(message = "Email must be valid")
    private String email;

    /**
     * Credentials of student
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MemberDTO member;

    /**
     * Exams which student is taking
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Collection<ResultExamDTO> results;
}
