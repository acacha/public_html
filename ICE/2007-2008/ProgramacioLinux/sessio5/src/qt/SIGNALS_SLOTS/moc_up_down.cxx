/****************************************************************************
** UpDownWidget meta object code from reading C++ file 'up_down.hxx'
**
** Created: Sat Feb 6 11:37:15 1999
**      by: The Qt Meta Object Compiler ($Revision: 2.25.2.11 $)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#if !defined(Q_MOC_OUTPUT_REVISION)
#define Q_MOC_OUTPUT_REVISION 2
#elif Q_MOC_OUTPUT_REVISION != 2
#error "Moc format conflict - please regenerate all moc files"
#endif

#include "up_down.hxx"
#include <qmetaobject.h>


const char *UpDownWidget::className() const
{
    return "UpDownWidget";
}

QMetaObject *UpDownWidget::metaObj = 0;


#if QT_VERSION >= 200
static QMetaObjectInit init_UpDownWidget(&UpDownWidget::staticMetaObject);

#endif

void UpDownWidget::initMetaObject()
{
    if ( metaObj )
	return;
    if ( strcmp(QWidget::className(), "QWidget") != 0 )
	badSuperclassWarning("UpDownWidget","QWidget");

#if QT_VERSION >= 200
    staticMetaObject();
}

void UpDownWidget::staticMetaObject()
{
    if ( metaObj )
	return;
    QWidget::staticMetaObject();
#else

    QWidget::initMetaObject();
#endif

    metaObj = new QMetaObject( "UpDownWidget", "QWidget",
	0, 0,
	0, 0 );
}
