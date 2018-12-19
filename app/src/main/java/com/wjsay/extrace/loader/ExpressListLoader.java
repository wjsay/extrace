package com.wjsay.extrace.loader;

import java.util.List;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;

import com.wjsay.extrace.misc.model.ExpressSheet;
import com.wjsay.extrace.net.HttpAsyncTask;
import com.wjsay.extrace.net.HttpResponseParam.RETURN_STATUS;
import com.wjsay.extrace.net.IDataAdapter;
import com.wjsay.extrace.net.JsonUtils;
import com.wjsay.extrace.ui.main.ExTraceApplication;

public class ExpressListLoader extends HttpAsyncTask {

	String url;
	IDataAdapter<List<ExpressSheet>> adapter;
	private Activity context;

	public ExpressListLoader(IDataAdapter<List<ExpressSheet>> adpt, Activity context) {
		super(context);
		this.context = context;
		adapter = adpt;
		url = ((ExTraceApplication)context.getApplication()).getDomainServiceUrl();
	}

	@Override
	public void onDataReceive(String class_data, String json_data) {
		if(json_data.equals("Deleted")){
			//adapter.getData().remove(0);	//����ط����ô���
			Toast.makeText(context, "�����Ϣ��ɾ��!", Toast.LENGTH_SHORT).show();
		}
		else{
			List<ExpressSheet> cstm = JsonUtils.fromJson(json_data, new TypeToken<List<ExpressSheet>>(){});
			adapter.setData(cstm);
			adapter.notifyDataSetChanged();
		}
	}

	@Override
	public void onStatusNotify(RETURN_STATUS status, String str_response) {
		Log.i("onStatusNotify", "onStatusNotify: " + str_response);
	}

	public void LoadExpressListInPackage(String pkgId)
	{
		url += "getExpressListInPackage/PackageId/"+pkgId+"?_type=json";
		try {
			execute(url, "GET");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
