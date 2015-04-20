<%@ include file="all.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>


<script src="./js/vendor/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./js/vendor/video.js"></script>
    <script src="./js/flat-ui.min.js"></script>
    <script src="./js/Chart.min.js"></script>
    <script src="http://cdn.bootcss.com/modernizr/2.8.2/modernizr.min.js"></script>
<!-- 模态框（Modal） -->
    <!-- 小于十天模态框（Modal） -->
    <div class="modal fade" id="goods-10" tabindex="-1" role="dialog" 
       aria-labelledby="addgoods" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">保质期小于10天的商品</h4>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="table-responsive">
                <table class="table table-striped" id="tableGood">
                    <tr>
                      <th>商品名称</th>
                      <th>商品编码</th>
                      <th>保质期剩余（天）</th>
                      <th>数量</th>
                    </tr>
					<tbody>
                    <tr>
                      <td>百威红瓶9.7度500ml</td>
                      <td>001</td>
                      <td>9</td>
                      <td>231</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->