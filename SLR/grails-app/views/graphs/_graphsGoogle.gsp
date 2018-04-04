<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js" ></script>
<script type="text/javascript">
   google.charts.load("current", {packages:['corechart','treemap','bar']});
   google.charts.setOnLoadCallback(drawColumnChart);
   google.charts.setOnLoadCallback(drawLineChart);
   //google.charts.setOnLoadCallback(drawAreaChart);
   google.charts.setOnLoadCallback(drawPieChart);
   google.charts.setOnLoadCallback(drawComboChart);
   function drawColumnChart() {

       var data = google.visualization.arrayToDataTable([<%=queryCriterion1%>]);
       var data2 = google.visualization.arrayToDataTable([<%=queryEngine1%>]);
       var data3 = google.visualization.arrayToDataTable([<%=queryDepartment1%>]);
       var data4 = google.visualization.arrayToDataTable([<%=queryType1%>]);
       var data5 = google.visualization.arrayToDataTable([<%=queryLanguage1%>]);
       var data6 = google.visualization.arrayToDataTable([<%=querySearch1%>]);

       var view = new google.visualization.DataView(data);
	   var view2 = new google.visualization.DataView(data2);
	   var view3 = new google.visualization.DataView(data3);
	   var view4 = new google.visualization.DataView(data4);
	   var view5 = new google.visualization.DataView(data5);
	   var view6 = new google.visualization.DataView(data6);
	   
	   view.setColumns([0, 1,
                        { calc: "stringify",
                          sourceColumn: 1,
                          type: "string",
                          role: "annotation" },
                        2]);
       
	   view2.setColumns([0, 1,
	                        { calc: "stringify",
	                          sourceColumn: 1,
	                          type: "string",
	                          role: "annotation" },
	                        2]);
	   view3.setColumns([0, 1,
	                        { calc: "stringify",
	                          sourceColumn: 1,
	                          type: "string",
	                          role: "annotation" },
	                        2]);
	   view4.setColumns([0, 1,
	                        { calc: "stringify",
	                          sourceColumn: 1,
	                          type: "string",
	                          role: "annotation" },
	                        2]);
	   view5.setColumns([0, 1,
	                        { calc: "stringify",
	                          sourceColumn: 1,
	                          type: "string",
	                          role: "annotation" },
	                        2]);
	   view6.setColumns([0, 1,
	                        { calc: "stringify",
	                          sourceColumn: 1,
	                          type: "string",
	                          role: "annotation" },
	                        2]);
 
	   var options = {
		         title: "References group by criterions",
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        bar: {groupWidth: "95%"}
		       };
	   var options2 = {
		         title: "References group by engines",
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        bar: {groupWidth: "95%"}
		       };
	   var options3 = {
		         title: "References group by departments",
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        bar: {groupWidth: "95%"}
		       };
	   var options4 = {
		         title: "References group by type document",
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        bar: {groupWidth: "95%"}
		       };
	   var options5 = {
		         title: "References group by language",
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        bar: {groupWidth: "95%"}
		       };
	   var options6 = {
		         title: "References group by included references",
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        bar: {groupWidth: "95%"}
		       };
     
       var chart = new google.visualization.ColumnChart(document.getElementById("chart_div"));
       chart.draw(view, options);       
       chart = new google.visualization.ColumnChart(document.getElementById("chart_div_6"));
       chart.draw(view2, options2);
       chart = new google.visualization.ColumnChart(document.getElementById("chart_div_11"));
       chart.draw(view3, options3);
       chart = new google.visualization.ColumnChart(document.getElementById("chart_div_16"));
       chart.draw(view4, options4);
       chart = new google.visualization.ColumnChart(document.getElementById("chart_div_21"));
       chart.draw(view5, options5);
       chart = new google.visualization.ColumnChart(document.getElementById("chart_div_26"));
       chart.draw(view6, options6);
   }
   function drawLineChart() {
	   var data = google.visualization.arrayToDataTable([<%=queryCriterion2%>]);
	   var data2 = google.visualization.arrayToDataTable([<%=queryEngine2%>]);
	   var data3 = google.visualization.arrayToDataTable([<%=queryDepartment2%>]);
	   var data4 = google.visualization.arrayToDataTable([<%=queryType2%>]);
	   var data5 = google.visualization.arrayToDataTable([<%=queryLanguage2%>]);

	   var options = {
		         title: 'References group by criterions',
		         legend: { position: 'right' },
		         curveType: 'function',
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        vAxis: { 
		            viewWindow: {
		                min:0
		            }
		        },
		        hAxis: {
		        	showTextEvery: <%=criterionShowTextEvery%>
		            }
		       };
	   var options2 = {
		         title: 'References group by engines',
		         legend: { position: 'right' },
		         curveType: 'function',
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        vAxis: { 
		            viewWindow: {
		                min:0
		            }
		        },
		        hAxis: {
		        	showTextEvery: <%=criterionShowTextEvery%>
		            }
		       };
	   var options3 = {
		         title: 'References group by departments',
		         legend: { position: 'right' },
		         curveType: 'function',
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        vAxis: { 
		            viewWindow: {
		                min:0
		            }
		        },
		        hAxis: {
		        	showTextEvery: <%=criterionShowTextEvery%>
		            }
		       };
	   var options4 = {
		         title: 'References group by type documents',
		         legend: { position: 'right' },
		         curveType: 'function',
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        vAxis: { 
		            viewWindow: {
		                min:0
		            }
		        },
		        hAxis: {
		        	showTextEvery: <%=criterionShowTextEvery%>
		            }
		       };

	   var options5 = {
		         title: 'References group by languages',
		         legend: { position: 'right' },
		         curveType: 'function',
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        vAxis: { 
		            viewWindow: {
		                min:0
		            }
		        },
		        hAxis: {
		        	showTextEvery: <%=criterionShowTextEvery%>
		            }
		       };

	   var chart = new google.visualization.LineChart(document.getElementById('chart_div_2'));
       chart.draw(data, options);
       chart = new google.visualization.LineChart(document.getElementById('chart_div_7'));
       chart.draw(data2, options2);
       chart = new google.visualization.LineChart(document.getElementById('chart_div_12'));
       chart.draw(data3, options3);
       chart = new google.visualization.LineChart(document.getElementById('chart_div_17'));
       chart.draw(data4, options4);
       chart = new google.visualization.LineChart(document.getElementById('chart_div_22'));
       chart.draw(data5, options5);
       
     }
   function drawAreaChart() {
	   var data = google.visualization.arrayToDataTable([<%=queryCriterion2%>]);
	   var data2 = google.visualization.arrayToDataTable([<%=queryEngine2%>]);
	   var data3 = google.visualization.arrayToDataTable([<%=queryDepartment2%>]);
	   var data4 = google.visualization.arrayToDataTable([<%=queryType2%>]);
	   var data5 = google.visualization.arrayToDataTable([<%=queryLanguage2%>]);

	   var options = {
		         title: 'References group by criterions',
		         hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        vAxis: { 
		            viewWindow: {
		                min:0
		            }
		        },
		        hAxis: {
		        	showTextEvery: <%=criterionShowTextEvery%>
		            }
		       };
	   var options2 = {
		         title: 'References group by engines',
		         hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        vAxis: { 
		            viewWindow: {
		                min:0
		            }
		        },
		        hAxis: {
		        	showTextEvery: <%=criterionShowTextEvery%>
		            }
		       };
	   var options3 = {
		         title: 'References group by departments',
		         hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        vAxis: { 
		            viewWindow: {
		                min:0
		            }
		        },
		        hAxis: {
		        	showTextEvery: <%=criterionShowTextEvery%>
		            }
		       };
	   var options4 = {
		         title: 'References group by type document',
		         hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        vAxis: { 
		            viewWindow: {
		                min:0
		            }
		        },
		        hAxis: {
		        	showTextEvery: <%=criterionShowTextEvery%>
		            }
		       };
	   var options5 = {
		         title: 'References group by languages',
		         hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
		         width: 800,
		         height: 400,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 600
		        },
		        vAxis: { 
		            viewWindow: {
		                min:0
		            }
		        },
		        hAxis: {
		        	showTextEvery: <%=criterionShowTextEvery%>
		            }
		       };
	   
	   var chart = new google.visualization.AreaChart(document.getElementById('chart_div_3'));
       chart.draw(data, options);
       chart = new google.visualization.AreaChart(document.getElementById('chart_div_8'));
       chart.draw(data2, options2);
       chart = new google.visualization.AreaChart(document.getElementById('chart_div_13'));
       chart.draw(data3, options3);
       chart = new google.visualization.AreaChart(document.getElementById('chart_div_18'));
       chart.draw(data4, options4);
       chart = new google.visualization.AreaChart(document.getElementById('chart_div_23'));
       chart.draw(data5, options5);
     }
   function drawPieChart() {

	   var data = google.visualization.arrayToDataTable([<%=queryCriterion1%>]);
	   var data2 = google.visualization.arrayToDataTable([<%=queryEngine1%>]);
	   var data3 = google.visualization.arrayToDataTable([<%=queryDepartment1%>]);
	   var data4 = google.visualization.arrayToDataTable([<%=queryType1%>]);
	   var data5 = google.visualization.arrayToDataTable([<%=queryLanguage1%>]);
	   var data6 = google.visualization.arrayToDataTable([<%=querySearch1%>]);
	   
	   var options = {
		         title: 'References group by criterions',
		         width: 850,
		         height: 400,
		         pieHole: 0.4,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 700
		        }
		       };
	   var options2 = {
		         title: 'References group by engines',
		         width: 850,
		         height: 400,
		         pieHole: 0.4,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 700
		        }
		       };
	   var options3 = {
		         title: 'References group by departments',
		         width: 850,
		         height: 400,
		         pieHole: 0.4,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 700
		        }
		       };
	   var options4 = {
		         title: 'References group by type documents',
		         width: 850,
		         height: 400,
		         pieHole: 0.4,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 700
		        }
		       };
	   var options5 = {
		         title: 'References group by languages',
		         width: 850,
		         height: 400,
		         pieHole: 0.4,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 700
		        }
		       };
	   var options6 = {
		         title: 'Searchs with included references',
		         width: 850,
		         height: 400,
		         pieHole: 0.4,
		         chartArea: {
		        	    left: 40,
		        	    top: 50,
		        	    width: 700
		        }
		       };

	   var chart = new google.visualization.PieChart(document.getElementById('chart_div_4'));
       chart.draw(data, options);
       chart = new google.visualization.PieChart(document.getElementById('chart_div_9'));
       chart.draw(data2, options2);
       chart = new google.visualization.PieChart(document.getElementById('chart_div_14'));
       chart.draw(data3, options3);
       chart = new google.visualization.PieChart(document.getElementById('chart_div_19'));
       chart.draw(data4, options4);
       chart = new google.visualization.PieChart(document.getElementById('chart_div_24'));
       chart.draw(data5, options5);
       chart = new google.visualization.PieChart(document.getElementById('chart_div_27'));
       chart.draw(data6, options6);
     }

   function drawComboChart() {
	   var data = google.visualization.arrayToDataTable([<%=queryCriterion3%>]);
	   var data2 = google.visualization.arrayToDataTable([<%=queryEngine3%>]);
	   var data3 = google.visualization.arrayToDataTable([<%=queryDepartment3%>]);
	   var data4 = google.visualization.arrayToDataTable([<%=queryType3%>]);
	   var data5 = google.visualization.arrayToDataTable([<%=queryLanguage3%>]);

	   var options = {
			      title : 'References by year group by criterions',
			      vAxis: {title: 'References'},
			      hAxis: {title: 'Range years'},
			      seriesType: 'bars',
			      series: {<%=totalCriterions%>: {type: 'line'}},
			      width: 800,
			      height: 400,
			      chartArea: {
			     	    left: 40,
			     	    top: 50,
			     	    width: 600
			     }
			    };
	   var options2 = {
			      title : 'References by year group by engines',
			      vAxis: {title: 'References'},
			      hAxis: {title: 'Range years'},
			      seriesType: 'bars',
			      series: {<%=totalEngines%>: {type: 'line'}},
			      width: 800,
			      height: 400,
			      chartArea: {
			     	    left: 40,
			     	    top: 50,
			     	    width: 600
			     }
			    };
	   var options3 = {
			      title : 'References by year group by departments',
			      vAxis: {title: 'References'},
			      hAxis: {title: 'Range years'},
			      seriesType: 'bars',
			      series: {<%=totalDepartments%>: {type: 'line'}},
			      width: 800,
			      height: 400,
			      chartArea: {
			     	    left: 40,
			     	    top: 50,
			     	    width: 600
			     }
			    };
	   var options4 = {
			      title : 'References by year group by type document',
			      vAxis: {title: 'References'},
			      hAxis: {title: 'Range years'},
			      seriesType: 'bars',
			      series: {<%=totalTypes%>: {type: 'line'}},
			      width: 800,
			      height: 400,
			      chartArea: {
			     	    left: 40,
			     	    top: 50,
			     	    width: 600
			     }
			    };
		var options5 = {
			      title : 'References by year group by language',
			      vAxis: {title: 'References'},
			      hAxis: {title: 'Range years'},
			      seriesType: 'bars',
			      series: {<%=totalLanguages%>: {type: 'line'}},
			      width: 800,
			      height: 400,
			      chartArea: {
			     	    left: 40,
			     	    top: 50,
			     	    width: 600
			     }
			    };
	   var chart = new google.visualization.ComboChart(document.getElementById('chart_div_5'));
	    chart.draw(data, options);
	    chart = new google.visualization.ComboChart(document.getElementById('chart_div_10'));
	    chart.draw(data2, options2);
	    chart = new google.visualization.ComboChart(document.getElementById('chart_div_15'));
	    chart.draw(data3, options3);
	    chart = new google.visualization.ComboChart(document.getElementById('chart_div_20'));
	    chart.draw(data4, options4);
  	    chart = new google.visualization.ComboChart(document.getElementById('chart_div_25'));
	    chart.draw(data5, options5);
   }
 </script>