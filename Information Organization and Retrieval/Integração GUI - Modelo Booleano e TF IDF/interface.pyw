import sys
from boolean_model import search
from tf_idf import gera_tf_idf
from PyQt5 import QtCore
from PyQt5 import QtGui
from PyQt5.QtGui import QKeySequence
from PyQt5.QtWidgets \
    import QApplication, QWidget, \
    QHBoxLayout, QGridLayout, QLineEdit, QTextEdit, \
    QPushButton, QShortcut, QLabel

__version__ = '0.1'
__author__ = 'Roberto Branco'


class MainWindow(QWidget):
    switch_window = QtCore.pyqtSignal()

    def __init__(self):
        QWidget.__init__(self)
        self.setWindowTitle('MENU')

        self.setFixedWidth(300)
        self.setFixedHeight(200)

        # Set the icon img
        self.setWindowIcon(QtGui.QIcon('icon.png'))

        layout = QGridLayout()

        # self.label = QLabel("Choose an option:")
        # self.label.setTextFormat(QtCore.Qt.TextFormat.RichText)
        # layout.addWidget(self.label)

        self.button = QPushButton('Boolean Model')
        self.button.clicked.connect(self.open_boolean_model)
        self.button.setFixedHeight(80)
        layout.addWidget(self.button)

        self.navTfIdf = QPushButton('TF IDF')
        self.navTfIdf.clicked.connect(self.open_tf_idf_win)
        self.navTfIdf.setFixedHeight(80)
        layout.addWidget(self.navTfIdf)

        self.setLayout(layout)

        self.bmWin = BooleanModelUi()
        self.tf_idfWin = WindowTfIdf()

    def open_boolean_model(self):
        self.bmWin.show()

    def open_tf_idf_win(self):
        self.tf_idfWin.show()


class BooleanModelUi(QWidget):
    switch_window = QtCore.pyqtSignal()

    def __init__(self):
        QWidget().__init__()
        # Set some main window's properties
        super().__init__()
        self.setWindowTitle('Boolean Model GUI')

        self.setMinimumSize(400, 500)

        # Set the icon img
        self.setWindowIcon(QtGui.QIcon('icon.png'))

        # Create and set the main widget
        self.layout = QGridLayout(self)

        # Create input field
        self.dirInput = QLineEdit()
        # Set some display's properties
        self.dirInput.setFixedHeight(30)
        self.font = self.dirInput.font()
        self.font.setPointSize(12)
        self.dirInput.setFont(self.font)
        self.dirInput.setPlaceholderText("Define the document base/directory's name")
        self.layout.addWidget(self.dirInput)

        # Create input field
        self.queryInput = QLineEdit()
        # Set some display's properties
        self.queryInput.setFixedHeight(40)
        self.font = self.queryInput.font()
        self.font.setPointSize(12)
        self.queryInput.setFont(self.font)
        self.queryInput.setPlaceholderText("Insert a query with ternary operators")
        self.layout.addWidget(self.queryInput)

        # Create search button
        self.button = QPushButton()
        self.button.setText('SEARCH')
        self.button.setFixedHeight(40)

        # Search Activators
        self.button.clicked.connect(self.execute_query)
        enter = QShortcut(QKeySequence(QtCore.Qt.Key_Return), self)
        enter.activated.connect(self.execute_query)

        self.layout.addWidget(self.button)

        self.display = QTextEdit()
        # Set some display's properties
        self.display.setReadOnly(True)
        self.display.setFontPointSize(11)
        # Add the display to the general layout
        self.layout.addWidget(self.display)

    def execute_query(self):
        query = self.queryInput.text()
        dir_name = self.dirInput.text()
        search(query, dir_name)

        file_path = "answer.txt"
        with open(file_path, 'r') as f:
            file_txt = f.read()
            f.close()
        file_txt = file_txt.split('\n')
        response = f'''{file_txt[0]} files satisfy the query!\n-------------------------------------------------------\nThe files are:\n'''
        for file in file_txt[1:]:
            response += file + "\n"
        self.display.setText(response)

    def switch(self):
        self.switch_window.emit()


class WindowTfIdf(QWidget):
    switch_window = QtCore.pyqtSignal()

    def __init__(self):
        QWidget().__init__()
        # Set some main window's properties
        super().__init__()
        self.setWindowTitle('TF IDF GUI')

        self.setMinimumSize(400, 500)

        # Set the icon img
        self.setWindowIcon(QtGui.QIcon('icon.png'))

        # Create and set the main widget
        self.layout = QGridLayout(self)

        # Create input field
        self.dirInput = QLineEdit()
        # Set some display's properties
        self.dirInput.setFixedHeight(30)
        self.font = self.dirInput.font()
        self.font.setPointSize(12)
        self.dirInput.setFont(self.font)
        self.dirInput.setPlaceholderText("Define the document base/directory's name")
        self.layout.addWidget(self.dirInput)

        # Create search button
        self.button = QPushButton('SEARCH')
        self.button.setFixedHeight(40)

        # Search Activators
        self.button.clicked.connect(self.execute_tf_idf)
        enter = QShortcut(QKeySequence(QtCore.Qt.Key_Return), self)
        enter.activated.connect(self.execute_tf_idf)

        self.layout.addWidget(self.button)

        self.display = QTextEdit()
        # Set some display's properties
        self.display.setReadOnly(True)
        self.display.setFontPointSize(11)
        # Add the display to the general layout
        self.layout.addWidget(self.display)

    def execute_tf_idf(self):
        dir_name = self.dirInput.text()
        gera_tf_idf(dir_name)

        file_path = "pesos.txt"
        with open(file_path, 'r') as f:
            file_txt = f.read()
            f.close()
        response = file_txt.replace('\n', '\n-----------------------------\n').replace(': ', ':\n').replace('  ', ' | ')
        self.display.setText(response)


# Client code
def main():
    app = QApplication(sys.argv)
    win = MainWindow()
    win.show()
    sys.exit(app.exec_())


if __name__ == '__main__':
    main()
