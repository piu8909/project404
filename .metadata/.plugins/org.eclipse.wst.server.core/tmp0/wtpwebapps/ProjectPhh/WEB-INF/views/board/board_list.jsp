<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>					
							<section>
									<header class="major">
										<h2>한글</h2>
									</header>
									<!-- Table -->
										<div class="table-wrapper">
											<table>
												<thead>
													<tr>
														<th>No</th>
														<th>Title</th>
														<th>Date</th>
													</tr>
												</thead>
												<tbody>
												<c:forEach items = "${b_list}" var = "b_list">
													<tr>
														<td>${b_list.num}</td>
														<td>${b_list.b_title}</td>
														<td>${b_list.b_name}</td>
													</tr>
													</c:forEach>
												</tbody>
												<tfoot>
											</table>
										</div>
								</section>