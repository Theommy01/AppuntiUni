@extends('layouts.skel')

@section('title', 'Inserimento nuovo F.A.Q.')

@section('content')
    <div class="wrapper">
        <!-- box che contiene la form di login -->
        <div class="form-box form-box-inputdialog">
            <h2>Inserisci Staff</h2>

            <!-- effettiva form di input -->
            {{ Form::open(array('url' => '/inserisciStaff', 'class' => 'contact-form')) }}
            @csrf
            <div class="form-row">
                <div class="form-left">
                    {{ Form::label('nome', 'Nome', ['class' => 'label-input']) }}
                    {{ Form::text('nome', '', ['class' => 'input', 'id' => 'nome', 'required' => 'required']) }}
                    @if ($errors->first('nome'))
                        <ul class="errors">
                            @foreach ($errors->get('nome') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('cognome', 'Cognome', ['class' => 'label-input']) }}
                    {{ Form::text('cognome', '', ['class' => 'input', 'id' => 'cognome', 'required' => 'required']) }}
                    @if ($errors->first('cognome'))
                        <ul class="errors">
                            @foreach ($errors->get('cognome') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('eta', 'Data di nascita', ['class' => 'label-input']) }}
                    {{ Form::date('eta', '',['class' => 'input', 'id' => 'eta', 'rules' => 'date_format:d-m-Y', 'required' => 'required']) }}
                    @if ($errors->first('cognome'))
                        <ul class="errors">
                            @foreach ($errors->get('eta') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('genere', 'Sesso', ['class' => 'label-radio']) }}

                    {{ Form::radio('genere', 'M', true, ['style' => 'display:inline;']) }}
                    {{ Form::label('genere', 'Maschio', ['style' => 'display:inline;']) }}
                    {{ Form::radio('genere', 'F', false, ['style' => 'display:inline;']) }}
                    {{ Form::label('genere', 'Femmina', ['style' => 'display:inline;']) }}
                    {{ Form::radio('genere', 'A', false, ['style' => 'display:inline;']) }}
                    {{ Form::label('genere', 'Altro', ['style' => 'display:inline;']) }}
                    @if ($errors->first('sesso'))
                        <ul class="errors">
                            @foreach ($errors->get('sesso') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('telefono', 'Numero di telefono', ['class' => 'label-input']) }}
                    {{ Form::text('telefono', '', ['class' => 'input', 'id' => 'telefono', 'rules' => 'phone', 'required' => 'required']) }}
                    @if ($errors->first('telefono'))
                        <ul class="errors">
                            @foreach ($errors->get('telefono') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif


                    {{ Form::label('email', 'Email', ['class' => 'label-input']) }}
                    {{ Form::text('email', '', ['class' => 'input', 'id' => 'email', 'rules' => 'email', 'required' => 'required']) }}
                    @if ($errors->first('email'))
                        <ul class="errors">
                            @foreach ($errors->get('email') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif
                </div>

                <div class="form-right">
                    {{ Form::label('username','Username' ) }}
                    {{ Form::text('username', '', array('required' => 'required')) }}
                    @if ($errors->first('username'))
                        <ul class="errors">
                            @foreach ($errors->get('username') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('password', 'Password') }}
                    {{ Form::password('password', array('required' => 'required')) }}
                    @if ($errors->first('password'))
                        <ul class="errors">
                            @foreach ($errors->get('password') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif
                </div>
            </div>
            {{ Form::submit('Inserisci questo membro dello Staff', ['class' => 'btn'])}}
            {{ Form::close() }}

            <div class="panel-buttons">
                <a class="btn btn-back" href="{{ route('gestioneStaff') }}">Torna indietro</a>
            </div>
        </div>
    </div>
@endsection

