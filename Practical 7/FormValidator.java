
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {
    @NotBlank
    private String name;

    @NotBlank
    @MaxLength(30)
    private String email;

    @MaxLength(10)
    private String phone;

    public SignupForm(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}

public class FormValidator {

    public static List<String> validate(Object obj)
            throws IllegalAccessException {

        List<String> errors = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (field.isAnnotationPresent(NotBlank.class)) {
                if (value == null ||
                    value.toString().trim().isEmpty()) {
                    errors.add(field.getName() + " must not be blank");
                }
            }

            if (field.isAnnotationPresent(MaxLength.class)
                    && value != null) {

                int max = field.getAnnotation(MaxLength.class).value();

                if (value.toString().length() > max) {
                    errors.add(field.getName()
                            + " exceeds maximum length " + max);
                }
            }
        }

        return errors;
    }

    public static void main(String[] args)
            throws IllegalAccessException {

        SignupForm form = new SignupForm(
                "", "this_is_a_very_long_email_address@example.com",
                "12345678901"
        );

        List<String> errors = validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid.");
        } else {
            System.out.println("Validation errors:");
            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}
