package info.tutsmodel.demosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    private UserDAO userDAO;
    private ArrayList<User> users;
    private ListView listView;

    private EditText edtName,edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        userDAO = new UserDAO(this);
        users = new ArrayList<>();


        loadList();

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                edtName = (EditText) findViewById(R.id.edtname);
                edtPass = (EditText) findViewById(R.id.edtpass);
                user.name =  edtName.getText().toString();
                user.pass = edtPass.getText().toString();
                Log.d("TAG",edtPass.getText().toString());
                userDAO.inserUser(user);
                loadList();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                userDAO.deleteUser(users.get(position).id);
                loadList();
            }
        });

    }

    private void loadList(){
        users = userDAO.getUsers();
        UserAdapter adapter = new UserAdapter(this,users);
        listView.setAdapter(adapter);
    }
}
