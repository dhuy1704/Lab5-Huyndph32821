package com.huynd17.volley

import android.content.Context
import android.widget.TextView
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class VolleyFn1 {
    var strJSON = ""
    //ham doc du lieu tu API

    fun getAllData(context: Context, textView: TextView){
        //1. Tao request
        val queue = Volley.newRequestQueue(context);
        //2. Truyền url
        val url = "https://hungnttg.github.io/array_json_new.json";
        //3. Gọi request
        //mảng của đối tượng -> gọi mảng trước, đối tượng sau
        //JSONArrayRequest(url, thanhcong, thatbai)
        val request = JsonArrayRequest(url, {response ->
            for (i in 0 until response.length()){
                try {
                    val person = response.getJSONObject(i);
                    val id = person.getString("id");
                    val name = person.getString("name");
                    val email = person.getString("email");
                    //đưa tất cả chuỗi vào
                    strJSON += "Id: $id\n";
                    strJSON += "Name: $name\n";
                    strJSON += "Email: $email\n";
                }
                catch (e: Exception){
                    e.printStackTrace();
                }
            }
            textView.text = strJSON // hiển thị kết quả lên màn hình
        }, { error -> textView.text = error.message });
        //4. Thực thi request
        queue.add(request);
    }
}