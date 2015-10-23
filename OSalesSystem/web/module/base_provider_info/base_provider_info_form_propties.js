
	   
		            		 

	      	      // ----------------------------------------------------------------------//
			 
            		 	      	      // ----------------------------------------------------------------------//
			
            		 	      	      // ----------------------------------------------------------------------//
			 
            		 	      	      // ----------------------------------------------------------------------//
			
            		 	      	      // ----------------------------------------------------------------------//
			  {
                columnWidth : .25,
				layout : 'form',
				defaultType : 'textfield',
				baseCls : 'x-plain',
				defaults : {
					width : 250
				},
				items : [{
					id : 'providerinfo.status',
					name : 'providerinfo.status',
					fieldLabel : ' 状态',
					xtype : 'textfield',
					style : NoAllowBlankStyle,
					blankText : '不能为空！',
					allowBlank : false,
					listeners : {
						'specialkey' : function(field, e) {
						}
					}
				}]
			  },
            		 

// 1-1