
	      		 	      {
			name : 'stockpaymentdetail.killSumMoneyShow',
			mapping : 'killSumMoneyShow'
		},
		            		 	      		 

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
					id : 'stockpaymentdetail.killSumMoneyShow',
					name : 'stockpaymentdetail.killSumMoneyShow',
					fieldLabel : ' 抵消金额',
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