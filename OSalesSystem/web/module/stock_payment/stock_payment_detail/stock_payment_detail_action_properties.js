var stock_payment_detail_grid_column = {
   record : [
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
		    ],
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	column : [
	 new Ext.grid.ERPRowNumberer(),
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
            		 	      		 	 
	
	
	]
};
////////////////////////////////////////////////////////////////////////////////////

