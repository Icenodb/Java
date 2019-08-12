import com.stu.controller.CRUD;
import com.stu.model.Student;

public class main {
    public static void main(String[] args) {
        Student student=new Student("小王",3,23,"男","通信工程");
        CRUD.add(student);
        CRUD.del(3);
    }
}
