<%@ page import="es.uca.pfc.User" %>
<div class="row">
	   <div class="col-lg-3 col-md-6">
	       <div class="panel panel-primary">
	           <div class="panel-heading">
	               <div class="row">
	                   <div class="col-xs-3">
	                       <i class="fa fa-folder-open fa-5x"></i>
	                   </div>
	                   <div class="col-xs-9 text-right">
	                       <div class="huge">${(User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.slrs.size() > 100 ? "+100" : User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.slrs.size().toString())}</div>
	                       <div>Systematic<br />Literature Reviews</div>
	                   </div>
	               </div>
	           </div>
	           <g:link controller="slr" action="myList">
	               <div class="panel-footer">
	                   <span class="pull-left">View details</span>
	                   <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                   <div class="clearfix"></div>
	               </div>
	           </g:link>
	       </div>
	   </div>
	   <div class="col-lg-3 col-md-6">
	       <div class="panel panel-primary">
	           <div class="panel-heading">
	               <div class="row">
	                   <div class="col-xs-3">
	                       <i class="fa fa-book fa-5x"></i>
	                   </div>
	                   <div class="col-xs-9 text-right">
	                       <div class="huge">${totalRefsIncluded}</div>
	                       <div>Included<br />references</div>
	                   </div>
	               </div>
	           </div>
	           <g:link controller="slr" action="myList">
	               <div class="panel-footer">
	                   <span class="pull-left">View Details</span>
	                   <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                   <div class="clearfix"></div>
	               </div>
	           </g:link>
	       </div>
	   </div>
	   <div class="col-lg-3 col-md-6">
	       <div class="panel panel-primary">
	           <div class="panel-heading">
	               <div class="row">
	                   <div class="col-xs-3">
	                       <i class="fa fa-tasks fa-5x"></i>
	                   </div>
	                   <div class="col-xs-9 text-right">
	                       <div class="huge">${totalTaskSearchs}</div>
	                       <div>Searchs<br />in progress<br /></div>
	                   </div>
	               </div>
	           </div>
	           <g:link controller="index" action="taskSearchs">
	               <div class="panel-footer">
	                   <span class="pull-left">View Details</span>
	                   <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                   <div class="clearfix"></div>
	               </div>
	           </g:link>
	       </div>
	   </div>
	   <div class="col-lg-3 col-md-6">
	       <div class="panel panel-primary">
	           <div class="panel-heading">
	               <div class="row">
	                   <div class="col-xs-3">
	                       <i class="fa fa-group fa-5x"></i>
	                   </div>
	                   <div class="col-xs-9 text-right">
	                       <div class="huge">${(User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.friends.size() > 100 ? "+100" : User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.friends.size().toString())}</div>
	                       <div>Friends<br /><br /></div>
	                   </div>
	               </div>
	           </div>
	           <g:link controller="user" action="friends" params="[guid: "${User.get(sec.loggedInUserInfo(field:"id").toString().toLong()).userProfile.guid}"]">
	               <div class="panel-footer">
	                   <span class="pull-left">View Details</span>
	                   <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                   <div class="clearfix"></div>
	               </div>
	           </g:link>
	       </div>
	   </div>
</div>