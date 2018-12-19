package com.wjsay.extrace.loader;

import java.util.List;

import android.app.Activity;
import com.wjsay.extrace.misc.model.TransPackage;
import com.wjsay.extrace.net.HttpAsyncTask;
import com.wjsay.extrace.net.HttpResponseParam.RETURN_STATUS;
import com.wjsay.extrace.net.IDataAdapter;
import com.wjsay.extrace.ui.main.ExTraceApplication;

public class TransPackageListLoader extends HttpAsyncTask{

	String url;
	IDataAdapter<List<TransPackage>> adapter;
	private Activity context;
	
	public TransPackageListLoader(IDataAdapter<List<TransPackage>> adpt, Activity context) {
		super(context);
		this.context = context;
		adapter = adpt;
		url = ((ExTraceApplication)context.getApplication()).getDomainServiceUrl();
	}

	@Override
	public void onDataReceive(String class_name, String json_data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusNotify(RETURN_STATUS status, String str_response) {
		// TODO Auto-generated method stub
		
	}

}
