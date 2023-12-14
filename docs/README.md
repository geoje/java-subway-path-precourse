# 🚀 우테코 4기 코테 - 지하철 노선도 경로 조회 미션

우테코 4기 코테 **지하철 노선도 경로 조회 미션** 은 미리 지정된 지하철 노선 정보(각 역 간의 거리와 소요 시간)을 사용 하여 출발지와 도착지의 최단 거리 또는 최소 시간을 구해주는 프로그램입니다.

사용자는 경로 조희를 할 때 최단 거리 또는 최소 시간을 선택할 수 있으며 이후 출발역과 도착역을 입력하면 총 거리와 총 소요 시간과 경로를 알려줍니다.

---

## 🔍 목차

- ⚙️ 구현할 기능 목록
- 📋 프로젝트 구조
- ✨ 최종 코딩테스트를 통해 배운 것

---

## ⚙️ 구현할 기능 목록

예외 상황이 생기면 `[ERROR]` 로 시작하는 메세지를 출력한 후 다시 입력을 받습니다.

### 1️⃣ 메인 화면 출력과 기능 입력 ✔️

<table>
<tr>
    <th>동작</th>
    <th>예외 상황</th>
</tr>
<tr>
<td><ul>
    <li>
        메인 화면 출력 ✔️<br>
        <code>## 메인 화면</code><br>
        <code>1. 경로 조회</code><br>
        <code>Q. 종료</code>
    </li>
    <li>
        질문에 해당하는 아래 메세지 출력 ✔️<br>
        <code>## 원하는 기능을 선택하세요.</code>
    </li>
    <li>기능을 입력받고 잘 입력 받았는지 체크 ✔️</li>
</ul></td>
<td><ul>
    <li>
        입력받은 기능이 존재하지 않을 경우 ✔️<br>
        <code>[ERROR] 해당 기능은 존재하지 않습니다. 다시 입력해 주세요.</code>
    </li>
</ul></td>
</tr>
</table>

### 2️⃣ 경로 기준 출력과 기능 입력 ✔️

<table>
<tr>
    <th>동작</th>
    <th>예외 상황</th>
</tr>
<tr>
<td><ul>
    <li>
        경로 기준 출력 ✔️<br>
        <code>## 경로 기준</code><br>
        <code>1. 최단 거리</code><br>
        <code>2. 최소 시간</code><br>
        <code>B. 돌아가기</code>
    </li>
    <li>
        질문에 해당하는 아래 메세지 출력 ✔️<br>
        <code>## 원하는 기능을 선택하세요.</code>
    </li>
    <li>기능을 입력받고 잘 입력 받았는지 체크 ✔️</li>
</ul></td>
<td><ul>
    <li>
        입력받은 기능이 존재하지 않을 경우 ✔️<br>
        <code>[ERROR] 해당 기능은 존재하지 않습니다. 다시 입력해 주세요.</code>
    </li>
</ul></td>
</tr>
</table>

### 3️⃣ 출발역 및 도착역 입력

<table>
<tr>
    <th>동작</th>
    <th>예외 상황</th>
</tr>
<tr>
<td><ul>
    <li>
        질문에 해당하는 아래 메세지 출력 ✔️<br>
        <code>## 출발역을 입력하세요.</code>
    </li>
    <li>출발역을 입력받고 잘 입력 받았는지 체크 ✔️</li><br>
    <li>
        출발역을 정상적으로 받았을 경우 아래 메세지 출력 ✔️<br>
        <code>## 도착역을 입력하세요.</code>
    </li>
    <li>도착역을 입력받고 잘 입력 받았는지 체크</li>
</ul></td>
<td><ul>
    <li>
        입력받은 역이 존재하지 않을 경우 ✔️<br>
        <code>[ERROR] 해당 역은 존재하지 않습니다. 다시 입력해 주세요.</code>
    </li>
    <li>
        출발역과 도착역이 같을 경우 ✔️<br>
        <code>[ERROR] 출발역과 도착역이 동일합니다. 다시 입력해 주세요.</code>
    </li>
    <li>
        출발역과 도착역이 연결되어 있지 않으면 에러를 출력 ✔️<br>
        <code>[ERROR] 연결된 노선을 찾을 수 없습니다. 다시 입력해 주세요.</code>
    </li>
</ul></td>
</tr>
</table>

### 4️⃣ 조회 결과 출력 ✔️

<table>
<tr>
    <th>동작</th>
    <th>원리</th>
</tr>
<tr>
<td><ul>
    <li>
        입력받은 기준으로 출발역과 도착역의 총 거리와 총 소요시간을 계산한 후 출력 ✔️<br>
        <code>## 조회 결과</code><br>
        <code>[INFO] ---</code><br>
        <code>[INFO] 총 거리: 4km</code><br>
        <code>[INFO] 총 소요 시간: 11분</code><br>
        <code>[INFO] ---</code><br>
        <code>[INFO] 교대역</code><br>
        <code>[INFO] 강남역</code><br>
        <code>[INFO] 양재역</code>
    </li>
</ul></td>
<td><ul>
    <li><code>jgrapht</code> 라이브러리를 사용하여 <code>Dijkstra</code> 알고리즘의 원리대로 최단 경로를 구함</li>
    <li>최단 경로를 구할 때의 가중치는 사용자의 입력 <code>거리</code> 또는 <code>시간</code> 으로 결정</li>
</ul></td>
</tr>
</table>

### 5️⃣ 반복 ✔️

- 결과 출력까지 정상적으로 완료되었을 경우 `1️⃣ 메인 화면 출력과 기능 입력` 로 가서 메인 화면 출력부터 반복 실행

---

## 📋 프로젝트 구조

### 📦 패키지

<table>
    <tr>
        <th>Package</th>
        <th>Class</th>
        <th>Description</th>
    </tr>
    <tr>
        <td rowspan="6">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/constants.svg?sanitize=true"/>
            <b> constant</b>
        </td>
        <td><b>ErrorMessage</b></td>
        <td>예외 상황에 사용 되는 정적 메세지</td>
    </tr>
    <tr>
        <td><b>GeneralMessage</b></td>
        <td>일반 적인 입력 요청 또는 결과 알림에 사용 되는 메세지</td>
    </tr>
    <tr>
        <td><b>Line</b></td>
        <td></td>
    </tr>
    <tr>
        <td><b>MainChoice</b></td>
        <td></td>
    </tr>
    <tr>
        <td><b>Station</b></td>
        <td></td>
    </tr>
    <tr>
        <td><b>WeightChoice</b></td>
        <td></td>
    </tr>
    <tr>
        <td>
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/controllers.svg?sanitize=true"/>
            <b> controller</b>
        </td>
        <td><b>SubwayController</b></td>
        <td>입력을 받아 계산하고 출력 해주는 전체 진행 담당 컨트롤러</td>
    </tr>
    <tr>
        <td>
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/home.svg?sanitize=true"/>
            <b> domain</b>
        </td>
        <td><b>CostMeter</b></td>
        <td></td>
    </tr>
    <tr>
        <td rowspan="2">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/views.svg?sanitize=true"/>
            <b> view</b>
        </td>
        <td><b>InputView</b></td>
        <td>사용자에게 질문을 하고 입력을 받아주는 뷰</td>
    </tr>
    <tr>
        <td><b>OutputView</b></td>
        <td>사용자에게 일반적인 메세지와 결과 및 에외 메세지를 출력해주는 뷰</td>
    </tr>
</table>

---

## ✨ 최종 코딩테스트를 통해 배운 것

### 💡 XXXX

- XXXX