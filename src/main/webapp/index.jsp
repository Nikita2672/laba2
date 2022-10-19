<%--
  Created by IntelliJ IDEA.
  User: iwaa0
  Date: 11.10.2022
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="src/style/main.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
    <title>Main</title>
</head>
<div id="flex-container">
    <body>

    <div class="header">
        <h3 id="author" class="header__title header__title_animation">Nikita Ivanov<br>P32302 var: 852369</h3>
    </div>

    <div class="graph">
        <h3 class="header__title header__title_animation">Graphic</h3>
        <div class="graph__plot form__frame_animation">
            <td>
                <svg class="element" height="300" width="300">
                    <!--Координатные оси-->
                    <line x1="0" x2="300" y1="150" y2="150"></line>
                    <line x1="150" x2="150" y1="0" y2="300"></line>
                    <!--Стрелочки-->
                    <polygon points="150,0 145,15 155,15" stroke="black"></polygon>
                    <polygon points="300,150 285,145 285,155" stroke="black"></polygon>
                    <!--Прямоугольник в третьей четверти-->
                    <polygon points="150,150 150,250 200,250 200,150"></polygon>
                    <!--Четверть круга во второй четверти-->
                    <path d="M250,150 A100,100 45 0,0 150,50 L 150,150 Z"></path>
                    <!--Треугольник в первой четверти-->
                    <polygon points="150,150 100,150 150,250"></polygon>
                    <!-- Подписи к осям -->
                    <text x="285" y="135">X</text>
                    <text x="160" y="15">Y</text>
                    <!-- Метки для значений R на оси X -->
                    <line x1="50" x2="50" y1="140" y2="160"></line>
                    <line x1="100" x2="100" y1="140" y2="160"></line>
                    <line x1="200" x2="200" y1="140" y2="160"></line>
                    <line x1="250" x2="250" y1="140" y2="160"></line>
                    <!-- Метки для значений R на оси Y -->
                    <line x1="140" x2="160" y1="50" y2="50"></line>
                    <line x1="140" x2="160" y1="100" y2="100"></line>
                    <line x1="140" x2="160" y1="200" y2="200"></line>
                    <line x1="140" x2="160" y1="250" y2="250"></line>
                    <!-- Значения R на оси X -->
                    <text x="40" y="130">-R</text>
                    <text x="85" y="130">-R/2</text>
                    <text x="190" y="130">R/2</text>
                    <text x="245" y="130">R</text>
                    <!-- Значения R на оси Y -->
                    <text x="170" y="52.5">R</text>
                    <text x="170" y="102.5">R/2</text>
                    <text x="170" y="202.5">-R/2</text>
                    <text x="170" y="252.5">-R</text>
                </svg>
            </td>
        </div>
    </div>

    <div class="form">
        <h4 class="header__title header__title_animation">Form with coordinates</h4>
        <form class="form__frame form__frame_animation" onsubmit="receiveSubmit(); return false">
            <div class="values">
                <p class="values__x">
                    <label for="x_value">X:</label>
                    <button type="button" class="x-button" id="x-3" onclick="processFieldSelection(FIELD_X, '-3', 'x')">
                        -3
                    </button>
                    <button type="button" class="x-button" id="x-2" onclick="processFieldSelection(FIELD_X, '-2', 'x')">
                        -2
                    </button>
                    <button type="button" class="x-button" id="x-1" onclick="processFieldSelection(FIELD_X, '-1', 'x')">
                        -1
                    </button>
                    <button type="button" class="x-button" id="x0" onclick="processFieldSelection(FIELD_X, '0', 'x')">
                        0
                    </button>
                    <button type="button" class="x-button" id="x1" onclick="processFieldSelection(FIELD_X, '1', 'x')">
                        1
                    </button>
                    <button type="button" class="x-button" id="x2" onclick="processFieldSelection(FIELD_X, '2', 'x')">
                        2
                    </button>
                    <button type="button" class="x-button" id="x3" onclick="processFieldSelection(FIELD_X, '3', 'x')">
                        3
                    </button>
                    <button type="button" class="x-button" id="x4" onclick="processFieldSelection(FIELD_X, '4', 'x')">
                        4
                    </button>
                    <button type="button" class="x-button" id="x5" onclick="processFieldSelection(FIELD_X, '5', 'x')">
                        5
                    </button>
                    <input type="hidden" name="x_coord" id="x_value">
                    <label for="x_value" class="limitations">default 0</label>
                </p>
                <p class="values__y">
                    <label for="y_value">Y:</label><input id="y_value" type="text" class="input js-input js-input-Y"
                                                          name="y_value" oninput="validateY()"
                                                          placeholder="Please enter Y">
                    <label id="y-warning">Y in (-5; 5)</label>
                </p>
                <p class="values__r">
                    <label for="r_value">R:</label><input id="r_value" type="text" class="input js-input js-input-R"
                                                          name="r_value" oninput="validateR()"
                                                          placeholder="Please enter R">
                    <label id="r-warning">R in (2; 5)</label>
                </p>
                <p class="buttons">
                    <input class="button_animation" id="reset" type="reset" value="reset" onclick="cleanInput()">
                    <input class="button_animation" id="submit" type="submit" value="send">
                </p>
            </div>
        </form>
    </div>

    <div class="table_box">
        <h4 class="header__title header__title_animation">Table with results</h4>
        <table id="table_id" class="display table">
            <thead>
            <tr>
                <th>Coordinate X</th>
                <th>Coordinate Y</th>
                <th>Radius R</th>
                <th>Time</th>
                <th>Time completed(milliseconds)</th>
                <th>Result</th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    </body>
</div>
<script src="src/scripts/test.js"></script>
<script src="src/scripts/constants.js"></script>
<script src="src/scripts/reset.js"></script>
<script src="src/scripts/validator.js"></script>
<script src="src/scripts/processFieldSelection.js"></script>
<script src="src/scripts/graph.js"></script>
<script src="src/scripts/table.js"></script>
</html>
