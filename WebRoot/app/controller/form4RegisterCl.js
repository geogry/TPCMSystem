var save = function(form){
	if(form.form.isValid()){
		var passwordTxt = form.getChildByElement('password');
		var confirmTxt = form.getChildByElement('confirm');
		
		if(passwordTxt.getValue() != confirmTxt.getValue()){
			Ext.Msg.alert('错误', '密码不匹配，请重新输入！');
			passwordTxt.setValue('');
			confirmTxt.setValue('');
		} else {
			form.form.submit({
				url : 'register',
				success : function(form, action){
					Ext.Msg.alert('信息', '注册成功，即将跳转...！');
					window.location.href='loginInput';
				},
				failure : function(form, action){
					Ext.Msg.alert('信息', '注册失败，请重新再试！');
				}
			});
		}
	} else {
		Ext.Msg.alert('信息', '请正确填写你的信息！');
	}
};

var back = function(){
	window.location.href='listNotices';
};