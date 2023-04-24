package com.example.qlsv;

import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.math.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class HelloController implements Initializable {
    @FXML private TextField student_nameText;
    @FXML private TextField student_idText;
    @FXML private TextField student_contactText;
    @FXML private TextField student_addressText;
    @FXML private TextField student_searchText;
    @FXML private DatePicker student_birthPicker;
    @FXML private ChoiceBox<String> student_yearCB;
    @FXML private ChoiceBox<String> student_genderCB;
    @FXML private ChoiceBox<String> student_searchCB;
    @FXML private TableView<Student> student_tableView;
    @FXML private TableColumn<Student, String> student_name_Col;
    @FXML private TableColumn<Student, String> student_id_Col;
    @FXML private TableColumn<Student, String> student_gender_Col;
    @FXML private TableColumn<Student, String> student_year_Col;
    @FXML private TableColumn<Student, String> student_bd_Col;
    @FXML private TableColumn<Student, String> student_contact_Col;
    @FXML private TableColumn<Student, String> student_address_Col;

    @FXML private TextField course_nameText;
    @FXML private TextField course_idText;
    @FXML private TextField course_searchText;
    @FXML private ChoiceBox<String> course_semesterCB;
    @FXML private ChoiceBox<String> course_courseCB_1;
    @FXML private ChoiceBox<String> course_courseCB_2;
    @FXML private ChoiceBox<String> course_courseCB_3;
    @FXML private ChoiceBox<String> course_courseCB_4;
    @FXML private ChoiceBox<String> course_searchCB;
    @FXML private TableView<Course> course_tableView;
    @FXML private TableColumn<Course, String> course_name_Col;
    @FXML private TableColumn<Course, String> course_id_Col;
    @FXML private TableColumn<Course, String> course_semester_Col;
    @FXML private TableColumn<Course, String> course_course1_Col;
    @FXML private TableColumn<Course, String> course_course2_Col;
    @FXML private TableColumn<Course, String> course_course3_Col;
    @FXML private TableColumn<Course, String> course_course4_Col;

    @FXML private TextField score_nameText;
    @FXML private TextField score_idText;
    @FXML private TextField score_searchText;
    @FXML private TextField score_semesterText;
    @FXML private TextField score_course1Text;
    @FXML private TextField score_course2Text;
    @FXML private TextField score_course3Text;
    @FXML private TextField score_course4Text;
    @FXML private TextField score_score1Text;
    @FXML private TextField score_score2Text;
    @FXML private TextField score_score3Text;
    @FXML private TextField score_score4Text;
    @FXML private TextField score_GPAText;
    @FXML private ChoiceBox<String> score_searchCB;
    @FXML private TableView<Course> score_tableView;
    @FXML private TableColumn<Course, String> score_name_Col;
    @FXML private TableColumn<Course, String> score_id_Col;
    @FXML private TableColumn<Course, String> score_semester_Col;
    @FXML private TableColumn<Course, String> score_course1_Col;
    @FXML private TableColumn<Course, String> score_course2_Col;
    @FXML private TableColumn<Course, String> score_course3_Col;
    @FXML private TableColumn<Course, String> score_course4_Col;
    @FXML private TableColumn<Course, String> score_score1_Col;
    @FXML private TableColumn<Course, String> score_score2_Col;
    @FXML private TableColumn<Course, String> score_score3_Col;
    @FXML private TableColumn<Course, String> score_score4_Col;
    @FXML private TableColumn<Course, String> score_GPA_Col;
    private ObservableList<Student> StudentList;
    private ObservableList<Course> CourseList;
    private ObservableList<Course> ScoreList;

    @Override public void initialize(URL location, ResourceBundle resources) {
        StudentList = FXCollections.observableArrayList();
        student_name_Col.setCellValueFactory(new PropertyValueFactory<>("name"));
        student_id_Col.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        student_year_Col.setCellValueFactory(new PropertyValueFactory<>("year"));
        student_gender_Col.setCellValueFactory(new PropertyValueFactory<>("gender"));
        student_bd_Col.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        student_contact_Col.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        student_address_Col.setCellValueFactory(new PropertyValueFactory<>("address"));

        CourseList = FXCollections.observableArrayList();
        course_name_Col.setCellValueFactory(new PropertyValueFactory<>("name"));
        course_id_Col.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        course_semester_Col.setCellValueFactory(new PropertyValueFactory<>("semester"));
        course_course1_Col.setCellValueFactory(new PropertyValueFactory<>("course1"));
        course_course2_Col.setCellValueFactory(new PropertyValueFactory<>("course2"));
        course_course3_Col.setCellValueFactory(new PropertyValueFactory<>("course3"));
        course_course4_Col.setCellValueFactory(new PropertyValueFactory<>("course4"));

        ScoreList = FXCollections.observableArrayList();
        score_name_Col.setCellValueFactory(new PropertyValueFactory<>("name"));
        score_id_Col.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        score_semester_Col.setCellValueFactory(new PropertyValueFactory<>("semester"));
        score_course1_Col.setCellValueFactory(new PropertyValueFactory<>("course1"));
        score_course2_Col.setCellValueFactory(new PropertyValueFactory<>("course2"));
        score_course3_Col.setCellValueFactory(new PropertyValueFactory<>("course3"));
        score_course4_Col.setCellValueFactory(new PropertyValueFactory<>("course4"));
        score_score1_Col.setCellValueFactory(new PropertyValueFactory<>("score1"));
        score_score2_Col.setCellValueFactory(new PropertyValueFactory<>("score2"));
        score_score3_Col.setCellValueFactory(new PropertyValueFactory<>("score3"));
        score_score4_Col.setCellValueFactory(new PropertyValueFactory<>("score4"));
        score_GPA_Col.setCellValueFactory(new PropertyValueFactory<>("GPA"));

        student_tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                String name = newSelection.getName();
                String id = newSelection.getStudentId();
                String gender = newSelection.getGender();
                String birthDay = newSelection.getBirthday();
                String year = newSelection.getYear();
                String contact = newSelection.getContactNo();
                String address = newSelection.getAddress();
                student_nameText.setText(name);
                student_idText.setText(id);
                student_genderCB.setValue(gender);
                student_birthPicker.setValue(LocalDate.parse(birthDay));
                student_yearCB.setValue(year);
                student_contactText.setText(contact);
                student_addressText.setText(address);
            }
        });

        course_tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                String name = newSelection.getName();
                String id = newSelection.getStudentId();
                String semester = newSelection.getSemester();
                String course1 = newSelection.getCourse1();
                String course2 = newSelection.getCourse2();
                String course3 = newSelection.getCourse3();
                String course4 = newSelection.getCourse4();
                course_nameText.setText(name);
                course_idText.setText(id);
                course_semesterCB.setValue(semester);
                course_courseCB_1.setValue(course1);
                course_courseCB_2.setValue(course2);
                course_courseCB_3.setValue(course3);
                course_courseCB_4.setValue(course4);
            }
        });

        score_tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                String name = newSelection.getName();
                String id = newSelection.getStudentId();
                String semester = newSelection.getSemester();
                String course1 = newSelection.getCourse1();
                String course2 = newSelection.getCourse2();
                String course3 = newSelection.getCourse3();
                String course4 = newSelection.getCourse4();
                float score1 = newSelection.getScore1();
                float score2 = newSelection.getScore2();
                float score3 = newSelection.getScore3();
                float score4 = newSelection.getScore4();
                float GPA = newSelection.getGPA();
                score_nameText.setText(name);
                score_idText.setText(id);
                score_semesterText.setText(semester);
                score_course1Text.setText(course1);
                score_course2Text.setText(course2);
                score_course3Text.setText(course3);
                score_course4Text.setText(course4);
                score_score1Text.setText(String.valueOf(score1));
                score_score2Text.setText(String.valueOf(score2));
                score_score3Text.setText(String.valueOf(score3));
                score_score4Text.setText(String.valueOf(score4));
                score_GPAText.setText(String.valueOf(GPA));
            }
        });
    }

    @FXML protected void student_AddButtonAction() {
        if (student_nameText.getText().isEmpty() || student_idText.getText().isEmpty() || student_genderCB.getValue() == null || student_birthPicker.getValue() == null || student_yearCB.getValue() == null || student_contactText.getText().isEmpty() || student_addressText.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Thiếu dữ liệu!");
            alert.setContentText("Mời bạn nhập đầy đủ thông tin cho sinh viên");
            alert.showAndWait();
        } else {
            Student newStudent = new Student();
            newStudent.setName(student_nameText.getText());
            newStudent.setStudentId(student_idText.getText());
            newStudent.setGender(student_genderCB.getValue().toString());
            newStudent.setBirthday(student_birthPicker.getValue().toString());
            newStudent.setYear(student_yearCB.getValue().toString());
            newStudent.setContactNo(student_contactText.getText());
            newStudent.setAddress(student_addressText.getText());
            StudentList.add(newStudent);
            student_tableView.setItems(StudentList);
        }
    }

    @FXML protected void student_DeleteButtonAction() {
        Student selectedStudent = student_tableView.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            student_tableView.getItems().remove(selectedStudent);
        }
    }

    @FXML protected void student_ClearButtonAction() {
        student_tableView.getItems().clear();
    }

    @FXML protected void student_SaveButtonAction() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\PC\\IdeaProjects\\QLSV\\src\\main\\java\\com\\example\\qlsv\\student.bin"))) {
            for (Student student : student_tableView.getItems()) {
                oos.writeObject(student);
            }
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo!");
            alert.setHeaderText("Lưu thành công!");
            alert.setContentText("C:\\Users\\PC\\IdeaProjects\\QLSV\\src\\main\\java\\com\\example\\qlsv\\student.bin");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML protected void student_EditButtonAction() {
        Student selectedStudent = student_tableView.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            student_AddButtonAction();
            student_tableView.getItems().remove(selectedStudent);
        }
    }

    @FXML protected void student_LoadButtonAction() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\PC\\IdeaProjects\\QLSV\\src\\main\\java\\com\\example\\qlsv\\student.bin"))) {
            Object obj;
            StudentList.clear();
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof Student) {
                    Student student = (Student) obj;
                    StudentList.add(student);
                }
            }
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        student_tableView.setItems(StudentList);
    }

    @FXML protected void student_SearchButtonAction() {
        if (student_searchCB.getValue() == null || student_searchText.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo!");
            alert.setHeaderText("Thiếu dữ liệu!");
            alert.setContentText("Mời bạn nhập đầy đủ thông tin tìm kiếm!");
            alert.showAndWait();
        } else {
            student_LoadButtonAction();
            ObservableList<Student> searchStudents = FXCollections.observableArrayList();
            for (Student student : StudentList) {
                if (student_searchCB.getValue().equals("Name") && student.getName().contains(student_searchText.getText())) {
                    searchStudents.add(student);
                } else if (student_searchCB.getValue().equals("Student ID") && student.getStudentId().equals(student_searchText.getText())) {
                    searchStudents.add(student);
                } else if (student_searchCB.getValue().equals("Gender") && student.getGender().equals(student_searchText.getText())) {
                    searchStudents.add(student);
                } else if (student_searchCB.getValue().equals("Birth Day") && student.getBirthday().equals(student_searchText.getText())) {
                    searchStudents.add(student);
                } else if (student_searchCB.getValue().equals("Contact No.") && student.getContactNo().equals(student_searchText.getText())) {
                    searchStudents.add(student);
                } else if (student_searchCB.getValue().equals("Address") && student.getAddress().equals(student_searchText.getText())) {
                    searchStudents.add(student);
                }
            }
            student_tableView.setItems(searchStudents);
        }
    }

    @FXML protected void course_SearchSTButtonAction(){
        if (course_idText.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo!");
            alert.setHeaderText("Thiếu dữ liệu!");
            alert.setContentText("Mời bạn nhập ID sinh viên cần tìm kiếm!");
            alert.showAndWait();
        } else {
            student_LoadButtonAction();
            for (Student student : StudentList) {
                if (student.getStudentId().contains(course_idText.getText())) {
                    course_nameText.setText(student.getName());
                }
            }
        }
    }
    @FXML protected void course_AddButtonAction() {
        if (course_nameText.getText().isEmpty() || course_idText.getText().isEmpty() || course_semesterCB.getValue().isEmpty() || course_courseCB_1.getValue().isEmpty() || course_courseCB_2.getValue().isEmpty() || course_courseCB_3.getValue().isEmpty() || course_courseCB_4.getValue().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Thiếu dữ liệu!");
            alert.setContentText("Mời bạn nhập đầy đủ thông tin cho sinh viên");
            alert.showAndWait();
        } else {
            Course newCourse = new Course();
            newCourse.setName(course_nameText.getText());
            newCourse.setStudentId(course_idText.getText());
            newCourse.setSemester(course_semesterCB.getValue().toString());
            newCourse.setCourse1(course_courseCB_1.getValue().toString());
            newCourse.setCourse2(course_courseCB_2.getValue().toString());
            newCourse.setCourse3(course_courseCB_3.getValue().toString());
            newCourse.setCourse4(course_courseCB_4.getValue().toString());
            CourseList.add(newCourse);
            course_tableView.setItems(CourseList);
        }
    }

    @FXML protected void course_SaveButtonAction() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\PC\\IdeaProjects\\QLSV\\src\\main\\java\\com\\example\\qlsv\\course.bin"))) {
            for (Course course : course_tableView.getItems()) {
                oos.writeObject(course);
            }
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo!");
            alert.setHeaderText("Lưu thành công!");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML protected void course_LoadButtonAction() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\PC\\IdeaProjects\\QLSV\\src\\main\\java\\com\\example\\qlsv\\course.bin"))) {
            Object obj;
            CourseList.clear();
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof Course) {
                    Course course = (Course) obj;
                    CourseList.add(course);
                }
            }
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        course_tableView.setItems(CourseList);
    }

    @FXML protected void course_SearchButtonAction() {
        if (course_searchCB.getValue() == null || course_searchText.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo!");
            alert.setHeaderText("Thiếu dữ liệu!");
            alert.setContentText("Mời bạn nhập đầy đủ thông tin tìm kiếm!");
            alert.showAndWait();
        } else {
            course_LoadButtonAction();
            ObservableList<Course> filteredCourse = FXCollections.observableArrayList();
            for (Course course : CourseList) {
                if (course_searchCB.getValue().equals("Name") && course.getName().contains(course_searchText.getText())) {
                    filteredCourse.add(course);
                } else if (course_searchCB.getValue().equals("Student ID") && course.getStudentId().equals(course_searchText.getText())) {
                    filteredCourse.add(course);
                } else if (course_searchCB.getValue().equals("Semester") && course.getSemester().equals(course_searchText.getText())) {
                    filteredCourse.add(course);
                } else if (course_searchCB.getValue().equals("Course") && course.getCourse1().equals(course_searchText.getText())) {
                    filteredCourse.add(course);
                } else if (course_searchCB.getValue().equals("Course") && course.getCourse2().equals(course_searchText.getText())) {
                    filteredCourse.add(course);
                } else if (course_searchCB.getValue().equals("Course") && course.getCourse3().equals(course_searchText.getText())) {
                    filteredCourse.add(course);
                } else if (course_searchCB.getValue().equals("Course") && course.getCourse4().equals(course_searchText.getText())) {
                    filteredCourse.add(course);
                }
            }
            course_tableView.setItems(filteredCourse);
        }
    }

    @FXML protected void course_ClearButtonAction() {
        course_tableView.getItems().clear();
    }

    @FXML protected void course_DeleteButtonAction() {
        Course selectedCourse = course_tableView.getSelectionModel().getSelectedItem();
        if (selectedCourse != null) {
            course_tableView.getItems().remove(selectedCourse);
        }
    }

    @FXML protected void course_EditButtonAction() {
        Course selectedCourse = course_tableView.getSelectionModel().getSelectedItem();
        if (selectedCourse != null) {
            course_AddButtonAction();
            course_tableView.getItems().remove(selectedCourse);
        }
    }
    @FXML protected void score_CalculateGPA() {
        float score1 = Float.parseFloat(score_score1Text.getText());
        float score2 = Float.parseFloat(score_score2Text.getText());
        float score3 = Float.parseFloat(score_score3Text.getText());
        float score4 = Float.parseFloat(score_score4Text.getText());
        float gpa = (score1 + score2 + score3 + score4) / 4;
        BigDecimal GPA = new BigDecimal(gpa);
        GPA = GPA.setScale(2, RoundingMode.HALF_UP);
        score_GPAText.setText(GPA.toString());
    }

    @FXML protected void score_AddButtonAction() {
        if (score_semesterText.getText().isEmpty() || score_idText.getText().isEmpty() || score_score1Text.getText().isEmpty() || score_score2Text.getText().isEmpty() || score_score3Text.getText().isEmpty() || score_score4Text.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Thiếu dữ liệu!");
            alert.setContentText("Mời bạn nhập đầy đủ thông tin!");
            alert.showAndWait();
        } else {
            Course newScore = new Course();
            newScore.setName(score_nameText.getText());
            newScore.setStudentId(score_idText.getText());
            newScore.setSemester(score_semesterText.getText());
            newScore.setCourse1(score_course1Text.getText());
            newScore.setCourse2(score_course2Text.getText());
            newScore.setCourse3(score_course3Text.getText());
            newScore.setCourse4(score_course4Text.getText());
            newScore.setScore1(Float.parseFloat(score_score1Text.getText()));
            newScore.setScore2(Float.parseFloat(score_score2Text.getText()));
            newScore.setScore3(Float.parseFloat(score_score3Text.getText()));
            newScore.setScore4(Float.parseFloat(score_score4Text.getText()));
            score_CalculateGPA();
            newScore.setGPA(Float.parseFloat(score_GPAText.getText()));
            ScoreList.add(newScore);
            score_tableView.setItems(ScoreList);
        }
    }

    @FXML protected void score_EditButtonAction() {
        score_CalculateGPA();
        Course selectedScore = score_tableView.getSelectionModel().getSelectedItem();
        if (selectedScore != null) {
            score_AddButtonAction();
            score_tableView.getItems().remove(selectedScore);
        }
    }

    @FXML protected void score_ClearButtonAction() {
        score_tableView.getItems().clear();
    }

    @FXML protected void score_DeleteButtonAction() {
        Course selectedScore = score_tableView.getSelectionModel().getSelectedItem();
        if (selectedScore != null) {
            score_tableView.getItems().remove(selectedScore);
        }
    }

    @FXML protected void score_LoadButtonAction() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\PC\\IdeaProjects\\QLSV\\src\\main\\java\\com\\example\\qlsv\\score.bin"))) {
            Object obj;
            ScoreList.clear();
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof Course) {
                    Course score = (Course) obj;
                    ScoreList.add(score);
                }
            }
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        score_tableView.setItems(ScoreList);
    }

    @FXML protected void score_SaveButtonAction() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\PC\\IdeaProjects\\QLSV\\src\\main\\java\\com\\example\\qlsv\\score.bin"))) {
            for (Course score : score_tableView.getItems()) {
                oos.writeObject(score);
            }
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo!");
            alert.setHeaderText("Lưu thành công!");
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML protected void score_SearchCourseButtonAction() {
        if (score_idText.getText().isEmpty() || score_semesterText.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo!");
            alert.setHeaderText("Thiếu dữ liệu!");
            alert.setContentText("Mời bạn nhập đầy đủ thông tin tìm kiếm!");
            alert.showAndWait();
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\PC\\IdeaProjects\\QLSV\\src\\main\\java\\com\\example\\qlsv\\course.bin"))) {
                Object obj;
                CourseList.clear();
                while ((obj = ois.readObject()) != null) {
                    if (obj instanceof Course) {
                        Course course = (Course) obj;
                        CourseList.add(course);
                    }
                }
            } catch (EOFException e) {
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            for (Course course : CourseList) {
                if (course.getStudentId().contains(score_idText.getText()) && course.getSemester().contains(score_semesterText.getText())) {
                    score_nameText.setText(course.getName());
                    score_course1Text.setText(course.getCourse1());
                    score_course2Text.setText(course.getCourse2());
                    score_course3Text.setText(course.getCourse3());
                    score_course4Text.setText(course.getCourse4());
                }
            }
        }
    }

    @FXML protected void score_SearchInfoButtonAction() {
        if (score_searchCB.getValue() == null || score_searchText.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thông báo!");
            alert.setHeaderText("Thiếu dữ liệu!");
            alert.setContentText("Mời bạn nhập đầy đủ thông tin tìm kiếm!");
            alert.showAndWait();
        } else {
            score_LoadButtonAction();
            ObservableList<Course> filteredScore = FXCollections.observableArrayList();
            for (Course score : ScoreList) {
                if (score_searchCB.getValue().equals("Name") && score.getName().contains(score_searchText.getText())) {
                    filteredScore.add(score);
                } else if (score_searchCB.getValue().equals("Student ID") && score.getStudentId().equals(score_searchText.getText())) {
                    filteredScore.add(score);
                } else if (score_searchCB.getValue().equals("Semester") && score.getSemester().equals(score_searchText.getText())) {
                    filteredScore.add(score);
                } else if (score_searchCB.getValue().equals("GPA >= n") && score.getGPA() >= Float.valueOf(score_searchText.getText())) {
                    filteredScore.add(score);
                }
            }
            score_tableView.setItems(filteredScore);
        }
    }
}
