import javax.swing.*;
import java.util.ArrayList;

class StudentListModel extends AbstractListModel<String> {
    ArrayList<Server.ClientHandler> alStudent;

    public StudentListModel(ArrayList<Server.ClientHandler> alS) {
        alStudent = alS;
    }

    @Override
    public int getSize() {
        return alStudent.size();
    }

    @Override
    public String getElementAt(int index) {
        return alStudent.get(index).studentName;
    }

}