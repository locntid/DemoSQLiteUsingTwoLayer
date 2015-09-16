package info.tutsmodel.demosqlite;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by locnt_000 on 9/16/2015.
 */
public class UserAdapter extends ArrayAdapter<User> {
    private Activity activity;
    private List<User> list;
    public UserAdapter(Activity activity, List<User> list) {
        super(activity, R.layout.user_item,list);
        this.activity = activity;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        User user = list.get(position);

        LayoutInflater inflater = activity.getLayoutInflater();
        View row = inflater.inflate(R.layout.user_item, null);

        TextView name = (TextView) row.findViewById(R.id.txtname);
        TextView pass = (TextView) row.findViewById(R.id.txtpass);

        name.setText(user.name);
        pass.setText(user.pass);
        return row;
    }
}
