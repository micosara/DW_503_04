<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/module/header.jsp" %>   

<!-- Daterange picker -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/daterangepicker/daterangepicker.css">
  
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">공지사항</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item">커뮤니티</li>
              <li class="breadcrumb-item active">공지사항</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
        	<div class="col-sm-12">
        		<div class="small-box bg-info">
	              <div class="inner">
	                <h3>주요 사항</h3>
	
	                <p>전체 공지 필수 내용</p>
	              </div>
	              <div class="icon">
	                <i class="ion ion-bag"></i>
	              </div>
	              <a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
	            </div>
        	</div>
        </div>
        <!-- /.row -->
        
        <div class="row">
        	<div class="col-md-6">
        		<div class="row">
        			<div class="col-sm-6">
        				<div class="card bg-gradient-success">
			              <div class="card-header border-0 ui-sortable-handle" style="cursor: move;">
			
			                <h3 class="card-title">
			                  <i class="far fa-calendar-alt"></i>
			                  Calendar
			                </h3>
			                <!-- tools card -->
			                <div class="card-tools">
			                  <!-- button with a dropdown -->
			                  <div class="btn-group">
			                    <button type="button" class="btn btn-success btn-sm dropdown-toggle" data-toggle="dropdown" data-offset="-52">
			                      <i class="fas fa-bars"></i>
			                    </button>
			                    <div class="dropdown-menu" role="menu">
			                      <a href="#" class="dropdown-item">Add new event</a>
			                      <a href="#" class="dropdown-item">Clear events</a>
			                      <div class="dropdown-divider"></div>
			                      <a href="#" class="dropdown-item">View calendar</a>
			                    </div>
			                  </div>
			                  <button type="button" class="btn btn-success btn-sm" data-card-widget="collapse">
			                    <i class="fas fa-minus"></i>
			                  </button>
			                  <button type="button" class="btn btn-success btn-sm" data-card-widget="remove">
			                    <i class="fas fa-times"></i>
			                  </button>
			                </div>
			                <!-- /. tools -->
			              </div>
			              <!-- /.card-header -->
			              <div class="card-body pt-0">
			                <!--The calendar -->
			                <div id="calendar" style="width: 100%"><div class="bootstrap-datetimepicker-widget usetwentyfour"><ul class="list-unstyled"><li class="show"><div class="datepicker"><div class="datepicker-days" style=""><table class="table table-sm"><thead><tr><th class="prev" data-action="previous"><span class="fa fa-chevron-left" title="Previous Month"></span></th><th class="picker-switch" data-action="pickerSwitch" colspan="5" title="Select Month">July 2025</th><th class="next" data-action="next"><span class="fa fa-chevron-right" title="Next Month"></span></th></tr><tr><th class="dow">Su</th><th class="dow">Mo</th><th class="dow">Tu</th><th class="dow">We</th><th class="dow">Th</th><th class="dow">Fr</th><th class="dow">Sa</th></tr></thead><tbody><tr><td data-action="selectDay" data-day="06/29/2025" class="day old weekend">29</td><td data-action="selectDay" data-day="06/30/2025" class="day old">30</td><td data-action="selectDay" data-day="07/01/2025" class="day">1</td><td data-action="selectDay" data-day="07/02/2025" class="day">2</td><td data-action="selectDay" data-day="07/03/2025" class="day">3</td><td data-action="selectDay" data-day="07/04/2025" class="day">4</td><td data-action="selectDay" data-day="07/05/2025" class="day weekend">5</td></tr><tr><td data-action="selectDay" data-day="07/06/2025" class="day weekend">6</td><td data-action="selectDay" data-day="07/07/2025" class="day active today">7</td><td data-action="selectDay" data-day="07/08/2025" class="day">8</td><td data-action="selectDay" data-day="07/09/2025" class="day">9</td><td data-action="selectDay" data-day="07/10/2025" class="day">10</td><td data-action="selectDay" data-day="07/11/2025" class="day">11</td><td data-action="selectDay" data-day="07/12/2025" class="day weekend">12</td></tr><tr><td data-action="selectDay" data-day="07/13/2025" class="day weekend">13</td><td data-action="selectDay" data-day="07/14/2025" class="day">14</td><td data-action="selectDay" data-day="07/15/2025" class="day">15</td><td data-action="selectDay" data-day="07/16/2025" class="day">16</td><td data-action="selectDay" data-day="07/17/2025" class="day">17</td><td data-action="selectDay" data-day="07/18/2025" class="day">18</td><td data-action="selectDay" data-day="07/19/2025" class="day weekend">19</td></tr><tr><td data-action="selectDay" data-day="07/20/2025" class="day weekend">20</td><td data-action="selectDay" data-day="07/21/2025" class="day">21</td><td data-action="selectDay" data-day="07/22/2025" class="day">22</td><td data-action="selectDay" data-day="07/23/2025" class="day">23</td><td data-action="selectDay" data-day="07/24/2025" class="day">24</td><td data-action="selectDay" data-day="07/25/2025" class="day">25</td><td data-action="selectDay" data-day="07/26/2025" class="day weekend">26</td></tr><tr><td data-action="selectDay" data-day="07/27/2025" class="day weekend">27</td><td data-action="selectDay" data-day="07/28/2025" class="day">28</td><td data-action="selectDay" data-day="07/29/2025" class="day">29</td><td data-action="selectDay" data-day="07/30/2025" class="day">30</td><td data-action="selectDay" data-day="07/31/2025" class="day">31</td><td data-action="selectDay" data-day="08/01/2025" class="day new">1</td><td data-action="selectDay" data-day="08/02/2025" class="day new weekend">2</td></tr><tr><td data-action="selectDay" data-day="08/03/2025" class="day new weekend">3</td><td data-action="selectDay" data-day="08/04/2025" class="day new">4</td><td data-action="selectDay" data-day="08/05/2025" class="day new">5</td><td data-action="selectDay" data-day="08/06/2025" class="day new">6</td><td data-action="selectDay" data-day="08/07/2025" class="day new">7</td><td data-action="selectDay" data-day="08/08/2025" class="day new">8</td><td data-action="selectDay" data-day="08/09/2025" class="day new weekend">9</td></tr></tbody></table></div><div class="datepicker-months" style="display: none;"><table class="table-condensed"><thead><tr><th class="prev" data-action="previous"><span class="fa fa-chevron-left" title="Previous Year"></span></th><th class="picker-switch" data-action="pickerSwitch" colspan="5" title="Select Year">2025</th><th class="next" data-action="next"><span class="fa fa-chevron-right" title="Next Year"></span></th></tr></thead><tbody><tr><td colspan="7"><span data-action="selectMonth" class="month">Jan</span><span data-action="selectMonth" class="month">Feb</span><span data-action="selectMonth" class="month">Mar</span><span data-action="selectMonth" class="month">Apr</span><span data-action="selectMonth" class="month">May</span><span data-action="selectMonth" class="month">Jun</span><span data-action="selectMonth" class="month active">Jul</span><span data-action="selectMonth" class="month">Aug</span><span data-action="selectMonth" class="month">Sep</span><span data-action="selectMonth" class="month">Oct</span><span data-action="selectMonth" class="month">Nov</span><span data-action="selectMonth" class="month">Dec</span></td></tr></tbody></table></div><div class="datepicker-years" style="display: none;"><table class="table-condensed"><thead><tr><th class="prev" data-action="previous"><span class="fa fa-chevron-left" title="Previous Decade"></span></th><th class="picker-switch" data-action="pickerSwitch" colspan="5" title="Select Decade">2020-2029</th><th class="next" data-action="next"><span class="fa fa-chevron-right" title="Next Decade"></span></th></tr></thead><tbody><tr><td colspan="7"><span data-action="selectYear" class="year old">2019</span><span data-action="selectYear" class="year">2020</span><span data-action="selectYear" class="year">2021</span><span data-action="selectYear" class="year">2022</span><span data-action="selectYear" class="year">2023</span><span data-action="selectYear" class="year">2024</span><span data-action="selectYear" class="year active">2025</span><span data-action="selectYear" class="year">2026</span><span data-action="selectYear" class="year">2027</span><span data-action="selectYear" class="year">2028</span><span data-action="selectYear" class="year">2029</span><span data-action="selectYear" class="year old">2030</span></td></tr></tbody></table></div><div class="datepicker-decades" style="display: none;"><table class="table-condensed"><thead><tr><th class="prev" data-action="previous"><span class="fa fa-chevron-left" title="Previous Century"></span></th><th class="picker-switch" data-action="pickerSwitch" colspan="5">2000-2090</th><th class="next" data-action="next"><span class="fa fa-chevron-right" title="Next Century"></span></th></tr></thead><tbody><tr><td colspan="7"><span data-action="selectDecade" class="decade old" data-selection="2006">1990</span><span data-action="selectDecade" class="decade" data-selection="2006">2000</span><span data-action="selectDecade" class="decade" data-selection="2016">2010</span><span data-action="selectDecade" class="decade active" data-selection="2026">2020</span><span data-action="selectDecade" class="decade" data-selection="2036">2030</span><span data-action="selectDecade" class="decade" data-selection="2046">2040</span><span data-action="selectDecade" class="decade" data-selection="2056">2050</span><span data-action="selectDecade" class="decade" data-selection="2066">2060</span><span data-action="selectDecade" class="decade" data-selection="2076">2070</span><span data-action="selectDecade" class="decade" data-selection="2086">2080</span><span data-action="selectDecade" class="decade" data-selection="2096">2090</span><span data-action="selectDecade" class="decade old" data-selection="2106">2100</span></td></tr></tbody></table></div></div></li><li class="picker-switch accordion-toggle"></li></ul></div></div>
			              </div>
			              <!-- /.card-body -->
			            </div>
        			</div>
        			<div class="col-sm-6">
        				<div class="col-sm-12">
        					<div class="small-box bg-success">
				              <div class="inner">
				                <h3>53<sup style="font-size: 20px">%</sup></h3>
				
				                <p>Bounce Rate</p>
				              </div>
				              <div class="icon">
				                <i class="ion ion-stats-bars"></i>
				              </div>
				              <a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
				            </div>
        				</div>
        				<div class="col-sm-12">
        					<div class="small-box bg-warning">
				              <div class="inner">
				                <h3>44</h3>
				
				                <p>User Registrations</p>
				              </div>
				              <div class="icon">
				                <i class="ion ion-person-add"></i>
				              </div>
				              <a href="#" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
				            </div>
        				</div>
        			</div>
        		</div>
        	</div>
        	<div class="col-md-6">
        		<div class="row">
        			<div class="col-sm-12">
        				<div class="card card-primary">
			              <div class="card-header">
			                <h3 class="card-title">Quick Example</h3>
			              </div>
			              <!-- /.card-header -->
			              <!-- form start -->
			              <form>
			                <div class="card-body">
			                  <div class="form-group">
			                    <label for="exampleInputEmail1">Email address</label>
			                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
			                  </div>
			                  <div class="form-group">
			                    <label for="exampleInputPassword1">Password</label>
			                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
			                  </div>
			                  <div class="form-group">
			                    <label for="exampleInputFile">File input</label>
			                    <div class="input-group">
			                      <div class="custom-file">
			                        <input type="file" class="custom-file-input" id="exampleInputFile">
			                        <label class="custom-file-label" for="exampleInputFile">Choose file</label>
			                      </div>
			                      <div class="input-group-append">
			                        <span class="input-group-text">Upload</span>
			                      </div>
			                    </div>
			                  </div>
			                  <div class="form-check">
			                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
			                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
			                  </div>
			                </div>
			                <!-- /.card-body -->
			
			                <div class="card-footer">
			                  <button type="submit" class="btn btn-primary">Submit</button>
			                </div>
			              </form>
			            </div>
        			</div>
        		</div>
        		<div class="row">
        			<div class="col-sm-3">
        				<div class="info-box bg-info">
			              <span class="info-box-icon"><i class="far fa-bookmark"></i></span>
			
			              <div class="info-box-content">
			                <span class="info-box-text">Bookmarks</span>
			                <span class="info-box-number">41,410</span>
			
			                <div class="progress">
			                  <div class="progress-bar" style="width: 70%"></div>
			                </div>
			                <span class="progress-description">
			                  70% Increase in 30 Days
			                </span>
			              </div>
			              <!-- /.info-box-content -->
           				 </div>
        			</div>
        			<div class="col-sm-3">
        				<div class="info-box bg-success">
			              <span class="info-box-icon"><i class="far fa-thumbs-up"></i></span>
			
			              <div class="info-box-content">
			                <span class="info-box-text">Likes</span>
			                <span class="info-box-number">41,410</span>
			
			                <div class="progress">
			                  <div class="progress-bar" style="width: 70%"></div>
			                </div>
			                <span class="progress-description">
			                  70% Increase in 30 Days
			                </span>
			              </div>
			              <!-- /.info-box-content -->
			            </div>
        			</div>
        			<div class="col-sm-3">
        				<div class="info-box bg-warning">
			              <span class="info-box-icon"><i class="far fa-calendar-alt"></i></span>
			
			              <div class="info-box-content">
			                <span class="info-box-text">Events</span>
			                <span class="info-box-number">41,410</span>
			
			                <div class="progress">
			                  <div class="progress-bar" style="width: 70%"></div>
			                </div>
			                <span class="progress-description">
			                  70% Increase in 30 Days
			                </span>
			              </div>
			              <!-- /.info-box-content -->
			            </div>
        			</div>
        			<div class="col-sm-3">
        				<div class="info-box bg-danger">
			              <span class="info-box-icon"><i class="fas fa-comments"></i></span>
			
			              <div class="info-box-content">
			                <span class="info-box-text">Comments</span>
			                <span class="info-box-number">41,410</span>
			
			                <div class="progress">
			                  <div class="progress-bar" style="width: 70%"></div>
			                </div>
			                <span class="progress-description">
			                  70% Increase in 30 Days
			                </span>
			              </div>
			              <!-- /.info-box-content -->
			            </div>
        			</div>
        		</div>
        	</div>
		</div>
        <!-- /.row -->
        
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->

<%@ include file="/WEB-INF/views/module/footer.jsp" %>  
<!-- daterangepicker -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/moment/moment.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
</body>
</html>
  
  
  
  
  