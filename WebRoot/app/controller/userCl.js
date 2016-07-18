//显示或隐藏修改用户信息面板
var showModifyUser = function(record, mainPanel, showUser){
	if(record.get('id')=='showUser'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(showUser).doLayout();
		showUser.show();
		showUser.form.load({
			url : 'common/showUser',
			method : 'POST',
			waitMsg : '数据正在加载...',
			waitTitle : '请稍后',
			timeout : 10,
			failure : function(form, action){
				Ext.Msg.alert('信息', '数据加载失败！');
			}
		});
	} else {
		showUser.hide();
	}
};

//显示或隐藏用户消息面板
var showMyMessage = function(record, mainPanel, showOldMessage, store){
	if(record.get('id')=='MessageManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(showOldMessage).doLayout();
		showOldMessage.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	} else {
		showOldMessage.hide();
	}
};

//显示或隐藏修改密码面板
var showModifyPass = function(record, mainPanel, modifyPass){
	if(record.get('id')=='modifyPass'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(modifyPass).doLayout();
		modifyPass.show();
	} else {
		modifyPass.hide();
	}
};

//显示或隐藏器件列表
var showElementList = function(record, mainPanel, showElements, store){
	if(record.get('id')=='listElements'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(showElements).doLayout();
		showElements.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	} else {
		showElements.hide();
	}
};

//显示或隐藏申领记录界面
var showBorrowRecord = function(record, mainPanel, borrowRecord, store){
	if(record.get('id') == 'showUserBorrow'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(borrowRecord).doLayout();
		borrowRecord.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	} else {
		borrowRecord.hide();
	}
};

//显示或隐藏申购界面
var showPor = function(record, mainPanel, por){
	if(record.get('id') == 'porInput'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(por).doLayout();
		por.show();
	}else{
		por.hide();
	}
};

//显示或隐藏申购记录界面
var showPorRecord = function(record, mainPanel, porRecord, store){
	if(record.get('id') == 'showUserPor'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(porRecord).doLayout();
		porRecord.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	}else{
		porRecord.hide();
	}
};

//显示或隐藏申购记录界面
var showReturnPanel = function(record, mainPanel, ReturnPanel, store){
	if(record.get('id') == 'returnElement'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(ReturnPanel).doLayout();
		ReturnPanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	}else{
		ReturnPanel.hide();
	}
};

//点击保存按钮之后，保存用户信息
var saveModifyUser = function(form) {
	if(form.form.isValid()){
		Ext.MessageBox.confirm('信息','确定要修改你的资料吗？', function(opt){
			if(opt == 'yes'){
				form.form.submit({
					url : 'common/modifyUser',
					method : 'POST',
					success : function(form, action){
						Ext.Msg.alert('信息', '修改成功！');
					},
					failure : function(form, action){
						Ext.Msg.alert('信息', '修改失败，请重新再试！');
					}
				});
			}
		});
	} else {
		Ext.Msg.alert('提示', '请正确填写你的信息！');
	}
};
//删除选中的消息
var deleteMessages = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'common/deleteMessage',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除一条消息
var deleteMessage = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'common/deleteMessage',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
//修改密码
var modifyPassword = function(form){
	if(form.form.isValid()){
		Ext.Msg.confirm('提示', '确定要修改你的密码吗？', function(opt){
			if(opt == 'yes'){
				form.form.submit({
					url : 'common/modifyPass',
					method : 'POST',
					success : function(form, action){
						Ext.Msg.alert('信息', '密码修改成功，请牢记你的新密码');
					},
					failure : function(form, action){
						Ext.Msg.alert('信息', '密码修改失败，' + action.result.errorMessage);
					}
				});
			}
		});
	} else {
		Ext.Msg.alert('警告', '请正确填写密码后再提交');
	}
};
//显示设备和耗材的详情
var showElementDetail = function(grid, form, row){
	var record = grid.getStore().getAt(row);
	
	form.getForm().findField('id').setValue(record.get('id'));
	form.getForm().findField('elementname').setValue(record.get('elementname'));
	form.getForm().findField('typename').setValue(record.get('type.typename'));
	form.getForm().findField('feature').setValue(record.get('feature'));
	form.getForm().findField('store').setValue(record.get('store'));
	form.getForm().findField('lockAddr').setValue(record.get('locker.addr'));
	form.getForm().findField('locker').setValue(record.get('locker.id'));
	if(record.get('img') != '')
		form.down('image').setSrc('uploads/' + record.get('img'));
};
//设置申领窗口
var setBorrowWindow = function(grid, form, row){
	var record = grid.getStore().getAt(row);
	
	form.down('[name=element.id]').setValue(record.get('id'));
	form.down('[name=elementname]').setValue(record.get('elementname'));
};
//保存申领信息
var saveBorrow = function(form){
	if(form.form.isValid()){
		form.form.submit({
			url : 'user/borrow',
			method : 'POST',
			success : function(form, action){
				Ext.Msg.alert('信息', '申领成功，请等待审核！');
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '申领失败，' + action.result.errorMessage);
			}
		});
	}else{
		Ext.Msg.alert('警告', '请填写正确的信息！');
	}
};
//保存申领信息
var savePor = function(form){
	if(form.form.isValid()){
		form.form.submit({
			url : 'user/por',
			method : 'POST',
			waitMsg : '提交中...',
			success : function(form, action){
				Ext.Msg.alert('信息', '申购成功，请等待管理员审核！');
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '申购失败，' + action.result.errorMessage);
			}
		});
	}else{
		Ext.Msg.alert('警告', '请填写正确的信息！');
	}
};
//归还设备
var returnElement = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要归还吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'user/returnElement',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '归还成功！<br/>请尽快将设备放回指定的位置');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '归还失败，请重试...');
				}
			});
		}
	});
};
//归还选中的设备
var returnElements = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要归还的数据！');
	}else{
		Ext.Msg.confirm('提示', '确定要归还吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'user/returnElement',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '归还成功！<br/>请尽快将设备放回指定的位置');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '归还失败，请重试...');
					}
				});
			}
		});
	}
};
//将新消息标记为已读
var checkMessage = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	var selectIds = record.get('id');
	
	Ext.Ajax.request({
		url : 'common/checkMessage',
		params : {selectIds : selectIds},
		method : 'POST',
		timeout : 10000,
		success : function(response){
			grid.getStore().remove(record);
		},
		failure : function(response){
			Ext.Msg.alert('信息', '标记失败，请重试...');
		}
	});
};
//标记选中的设备
var checkMessages = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要标记的数据！');
	}else{
		var selectIds = '';
		for(var i = 0; i < record.length; i++){
			if(i == 0){
				selectIds += record[i].get('id');
			} else {
				selectIds += ',' + record[i].get('id');
			}
		}

		Ext.Ajax.request({
			url : 'common/checkMessage',
			params : {selectIds : selectIds},
			method : 'POST',
			timeout : 10000,
			success : function(response){
				for(var i = 0; i < record.length; i++){
					grid.getStore().remove(record[i]);
				}
			},
			failure : function(response){
				Ext.Msg.alert('信息', '标记失败，请重试...');
			}
		});
	}
};
//删除通过的借用消息
var deletePassBorrow = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	if(record.get('returned') == 0){
		Ext.Msg.alert('警告', '你还没有归还设备，不能删除该记录！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				if(record.get('returned') == 1){
					var selectIds = record.get('id');
				}else{
					Ext.Msg.alert('警告', '选择的记录中含有设备未归还的记录，删除失败！');
					return;
				}
				
				Ext.Ajax.request({
					url : 'common/deletePassBorrow',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						grid.getStore().remove(record);
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除选中的通过申领信息
var deletePassBorrows = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(record.get('returned') == 1){
						if(i == 0){
							selectIds += record[i].get('id');
						} else {
							selectIds += ',' + record[i].get('id');
						}
					}else{
						Ext.Msg.alert('警告', '选择的记录中含有设备未归还的记录，删除失败！');
						return;
					}
				}
		
				Ext.Ajax.request({
					url : 'common/deletePassBorrow',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除拒绝的借用消息
var deleteTempBorrow = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'user/deleteTempBorrow',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，该记录可能已被审核');
				}
			});
		}
	});
};
//删除选中的拒绝申领信息
var deleteTempBorrows = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('警告', '没有选择要删除的数据');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'user/deleteTempBorrow',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，该记录可能已被审核');
					}
				});
			}
		});
	}
};
//删除拒绝的借用消息
var deleteRefuseBorrow = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'common/deleteRefuseBorrow',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
//删除选中的拒绝申领信息
var deleteRefuseBorrows = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'common/deleteRefuseBorrow',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除拒绝的借用消息
var deleteRefusePor = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'common/deleteRefusePor',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
//删除选中的拒绝申领信息
var deleteRefusePors = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'common/deleteRefusePor',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除拒绝的借用消息
var deleteTempPor = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'user/deleteTempPor',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，该记录可能已被审核');
				}
			});
		}
	});
};
//删除选中的拒绝申领信息
var deleteTempPors = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'user/deleteTempPor',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '部分记录删除失败<br/>部分记录可能已经被审核');
					}
				});
			}
		});
	}
};
var download = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	var filename = record.get('manual');
	if(filename != '')
		window.location.href = 'uploads/' + filename;
	else
		Ext.Msg.alert('信息', '该设备没有手册！');
};