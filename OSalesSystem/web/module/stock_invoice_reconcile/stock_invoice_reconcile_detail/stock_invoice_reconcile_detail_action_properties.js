var stock_invoice_reconcile_detail_grid_column = {
   record : [
         			  {
                    name : 'providerInfo.name',
					mapping : 'providerInfo'
                },
		 			  {
                    name : 'providerId',
					mapping : 'providerId'
                },
		 			  {
                    name : 'billType',
					mapping : 'billType'
                },
		 			  {
                    name : 'billNum',
					mapping : 'billNum'
                },
		 			  {
                    name : 'billDate',
					mapping : 'billDate'
                },
		 			  {
                    name : 'text',
					mapping : 'text'
                },
		 			  {
                    name : 'billSum',
					mapping : 'billSum'
                },
		 			  {
                    name : 'billSumMoneyShow',
					mapping : 'billSumMoneyShow'
                },
		 			  {
                    name : 'billSumMoneyHide',
					mapping : 'billSumMoneyHide'
                },
		 			  {
                    name : 'killSum',
					mapping : 'killSum'
                },
		 			  {
                    name : 'killSumMoneyShow',
					mapping : 'killSumMoneyShow'
                },
		 			  {
                    name : 'killSumMoneyHide',
					mapping : 'killSumMoneyHide'
                },
		 			  {
                    name : 'noKillSum',
					mapping : 'noKillSum'
                },
		 			  {
                    name : 'noKillSumMoneyShow',
					mapping : 'noKillSumMoneyShow'
                },
		 			  {
                    name : 'noKillSumMoneyHide',
					mapping : 'noKillSumMoneyHide'
                },
		 			  {
                    name : 'billInfo',
					mapping : 'billInfo'
                },
		    ],
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	column : [
	 new Ext.grid.ERPRowNumberer(),
	   	      			  {
                    header : '供应商',
		            width :   200,
		            dataIndex :'providerInfo.name',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
if(value.name==null ||  typeof(value.name) =='undefined' )   
  return null   
   else  
 return value.name ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '单据类型',
		            width :   200,
		            dataIndex :'billType',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '单据编号',
		            width :   200,
		            dataIndex :'billNum',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '单据日期',
		            width :   200,
		            dataIndex :'billDate',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '备注',
		            width :   200,
		            dataIndex :'text',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '单据金额',
		            width :   200,
		            dataIndex :'billSumMoneyShow',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      		 	      			  {
                    header : '抵消金额',
		            width :   200,
		            dataIndex :'killSumMoneyShow',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      		 	      			  {
                    header : '未抵消金额',
		            width :   200,
		            dataIndex :'noKillSumMoneyShow',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '单据信息',
		            width :   200,
		            dataIndex :'billInfo',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	 
	
	
	]
};
////////////////////////////////////////////////////////////////////////////////////

