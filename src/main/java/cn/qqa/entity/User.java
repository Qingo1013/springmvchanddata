package cn.qqa.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.Date;

public class User {
    @NotNull(message = "id不能为空")
    @Min(value = 1, message = "id必须大于0")
    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 4, max = 8, message = "用户名长度必须在{min}到{max}位之间")
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "用户名只能包含数字、大小写英文字母")
    private String username;
    @Past(message = "您难道穿越了吗？")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @NumberFormat(style = NumberFormat.Style.CURRENCY) //货币
    private Double balance;//余额 格式：￥5000
    private String[] hobbies;
    @Range(min = 2000, max = 1000000, message = "您的工资必须在{min}到{max}之间")
    @NumberFormat(pattern = "#,###.##")
    private Double salary;//工资 格式：10,000.00
    @Range(min = 0, max = 100, message = "任务完成度必须在{min}到{max}之间") //size的范围是int，range的范围是long，range可以控制的范围更大
    @NumberFormat(style = NumberFormat.Style.PERCENT)
    private Double taskCount;//工作完成百分比 格式：90% 提交时不加"%"会自动乘以100

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Double taskCount) {
        this.taskCount = taskCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", balance=" + balance +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", salary=" + salary +
                ", taskCount=" + taskCount +
                '}';
    }
}
