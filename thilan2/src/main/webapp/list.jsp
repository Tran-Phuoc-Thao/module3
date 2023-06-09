
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script>
        $(document).ready( function () {
            $('#myTable').DataTable({
                bFilter:false,
                aLengthMenu: [[5, 10, 20, 50], [5, 10, 20, 50]], // danh sách số trang trên 1 lần hiển thị bảng
                }
            );
        } );
        /* "bProcessing": true,
       "sAutoWidth": false,
       "bDestroy":true,
       "sPaginationType": "bootstrap", // full_numbers
       "iDisplayStart ": 10,
       "iDisplayLength": 10,
       "bPaginate": false, //hide pagination
       "bFilter": false, //hide Search bar
       "bInfo": false, // hide showing entries */
    </script>

</head>
<body style="background-image: url('http://thuthuatphanmem.vn/uploads/2018/08/21/hinh-nen-powerpoint-don-gian-dep-31_045407361.jpg');">

    <form action="/Product" method="get" >
        <table style="margin: auto">
            <tr>
                <th>Search by Name</th>
            </tr>
            <tr>
                <td><input type="text" name="name"  size="45"/></td>
                <td><input type="submit" value="search" name="action"/></td>
            </tr>
        </table>
    </form>

<div class="container">
    <caption><h2>List of Product</h2></caption>

    <!-- Button trigger modal -->
    <button style="float: right;width: 100px;height: 50px;solid:50px;color: fuchsia;background: paleturquoise " type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#add">
        Add
    </button>

    <form action="/Product?action=create"  method="post">
    <div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" >Add New Product</h5>
                </div>

                <div>
                    <table border="1" cellpadding="5">
                        <tr>
                            <th> name:</th>
                            <td>
                                <input type="text" name="name"  size="45"/>
                            </td>
                        </tr>
                        <tr>
                            <th>gia:</th>
                            <td>
                                <input type="text" name="gia"  size="45"/>
                            </td>
                        </tr>
                        <tr>
                            <th>So Luong:</th>
                            <td>
                                <input type="text" name="soLuong"  size="45"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Mau Sac:</th>
                            <td>
                                <input type="text" name="mauSac"  size="45"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Mo Ta:</th>
                            <td>
                                <input type="text" name="moTa"  size="45"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Danh Muc:</th>
                            <td>
                                <select name="idType">
                                    <c:forEach items="${list1}" var="congViec">
                                        <option value="${congViec.idType}"><c:out value="${congViec.name}"></c:out></option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                    </table>

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Xóa</button>
                </div>
            </div>
        </div>
    </div>
    </form>





    <table class="table table-striped table-bordered table-hover table-borderless display" id="myTable">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>TEN SAN PHAM</th>
            <th>GIA</th>
            <th>SO LUONG</th>
            <th>MAU SAC</th>
            <th>MO TA</th>
            <th>DANH MUC</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody style="text-align: left">
        <c:forEach var="l" items="${list}">
            <tr>
                <td><c:out value="${l.id}"/></td>
                <td><c:out value="${l.name}"/></td>
                <td><c:out value="${l.gia}"/></td>
                <td><c:out value="${l.soLuong}"/></td>
                <td><c:out value="${l.mauSac}"/></td>
                <td><c:out value="${l.moTa}"/></td>
                <td><c:out value="${l.category.name}"/></td>
                <td style="width: 50px">
                    <form method="post" action="/Product?action=edit">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal&id=${l.id}">
                        Edit
                    </button>

                    <!-- Modal -->
                    <div class="modal fade " id="exampleModal&id=${l.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" >
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Edit Product</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">

                                        <table>
                                            <tr>
                                                <th>Ten San Pham :</th>
                                                <td>
                                                    <input type="text" name="name" size="35"
                                                           value="<c:out value='${l.name}' />"
                                                    />
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>gia :</th>
                                                <td>
                                                    <input type="text" name="gia" size="35"
                                                           value="<c:out value='${l.gia}' />"
                                                    />
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>so luong:</th>
                                                <td>
                                                    <input type="text" name="soLuong" size="35"
                                                           value="<c:out value='${l.soLuong}' />"
                                                    />
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>mau sac:</th>
                                                <td>
                                                    <input type="text" name="mauSac" size="35"
                                                           value="<c:out value='${l.mauSac}' />"
                                                    />
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>mo ta :</th>
                                                <td>
                                                    <input type="text" name="moTa" size="35"
                                                           value="<c:out value='${l.moTa}' />"
                                                    />
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>ma cong viec:</th>
                                                <td>
                                                    <select name="idType">
                                                        <c:forEach items="${list1}" var="congViec">
                                                            <option value="${congViec.idType}"><c:out value="${congViec.name}"></c:out></option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                        </table>
                                        <input type="hidden" name="id"  size="30" value="${l.id}"/>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>

                        </div>
                    </div>
                    </form>
                </td>
                <td style="width: 50px">
                    <button style="float:left;width: 67px" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myDelete">
                        Delete
                    </button>
                    <div class="modal fade" id="myDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Đồng Ý Xóa</h5>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary" onclick="window.location.href='/Product?action=delete&id=${l.id}'">Xóa</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
