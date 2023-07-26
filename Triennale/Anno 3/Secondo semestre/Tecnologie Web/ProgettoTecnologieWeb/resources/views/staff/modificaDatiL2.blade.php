@extends('layouts.skel')

@section('title', 'Modifica dati personali dello staff')

@section('content')
    <div class="wrapper wrapper-register">
        <div class="form-box form-box-inputdialog">
            <h2>Modifica dati personali di: {{$dati['username']}}</h2>

            @if (session('success'))
                <div class="form-insertFAQ">
                    {{ session('success') }}
                </div>
            @endif
            <br>

            @csrf
            {{ Form::open(array('url' => '/modificaDatiL2/', 'enctype' => 'multipart/form-data', 'method' => 'PUT')) }}
            <div class="form-row">
                <div class="form-left">
                    {{ Form::label('nome', 'Nome', ['class' => 'label-input']) }}
                    {{ Form::text('nome', $dati['nome'], ['class' => 'input', 'id' => 'nome', 'required' => 'required']) }}
                    @if ($errors->first('nome'))
                        <ul class="errors">
                            @foreach ($errors->get('nome') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('cognome', 'Cognome', ['class' => 'label-input']) }}
                    {{ Form::text('cognome', $dati['cognome'], ['class' => 'input', 'id' => 'cognome', 'required' => 'required']) }}
                    @if ($errors->first('cognome'))
                        <ul class="errors">
                            @foreach ($errors->get('cognome') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('eta', 'Data di nascita', ['class' => 'label-input']) }}
                    {{ Form::date('eta', $dati['eta'], ['class' => 'input', 'id' => 'eta', 'rules' => 'date_format:d-m-Y', 'required' => 'required']) }}
                    @if ($errors->first('eta'))
                        <ul class="errors">
                            @foreach ($errors->get('eta') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('genere', 'Sesso', ['class' => 'label-radio']) }}
                    @if($dati['genere']=="M")
                        {{ Form::radio('genere', 'M', true, ['style' => 'display:inline;']) }}
                        {{ Form::label('genere', 'Maschio', ['style' => 'display:inline;']) }}
                        {{ Form::radio('genere', 'F', false, ['style' => 'display:inline;']) }}
                        {{ Form::label('genere', 'Femmina', ['style' => 'display:inline;']) }}
                        {{ Form::radio('genere', 'A', false, ['style' => 'display:inline;']) }}
                        {{ Form::label('genere', 'Altro', ['style' => 'display:inline;']) }}
                    @elseif($dati['genere']=="F")
                        {{ Form::radio('genere', 'M', false, ['style' => 'display:inline;']) }}
                        {{ Form::label('genere', 'Maschio', ['style' => 'display:inline;']) }}
                        {{ Form::radio('genere', 'F', true, ['style' => 'display:inline;']) }}
                        {{ Form::label('genere', 'Femmina', ['style' => 'display:inline;']) }}
                        {{ Form::radio('genere', 'A', false, ['style' => 'display:inline;']) }}
                        {{ Form::label('genere', 'Altro', ['style' => 'display:inline;']) }}
                    @elseif($dati['genere']=="A")
                        {{ Form::radio('genere', 'M', false, ['style' => 'display:inline;']) }}
                        {{ Form::label('genere', 'Maschio', ['style' => 'display:inline;']) }}
                        {{ Form::radio('genere', 'F', false, ['style' => 'display:inline;']) }}
                        {{ Form::label('genere', 'Femmina', ['style' => 'display:inline;']) }}
                        {{ Form::radio('genere', 'A', true, ['style' => 'display:inline;']) }}
                        {{ Form::label('genere', 'Altro', ['style' => 'display:inline;']) }}
                    @else
                        {{ Form::radio('genere', 'M', false, ['style' => 'display:inline;']) }}
                        {{ Form::label('genere', 'Maschio', ['style' => 'display:inline;']) }}
                        {{ Form::radio('genere', 'F', false, ['style' => 'display:inline;']) }}
                        {{ Form::label('genere', 'Femmina', ['style' => 'display:inline;']) }}
                        {{ Form::radio('genere', 'A', false, ['style' => 'display:inline;']) }}
                        {{ Form::label('genere', 'Altro', ['style' => 'display:inline;']) }}
                    @endif
                    @if ($errors->first('sesso'))
                        <ul class="errors">
                            @foreach ($errors->get('sesso') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('telefono', 'Numero di telefono', ['class' => 'label-input']) }}
                    {{ Form::text('telefono', $dati['telefono'], ['class' => 'input', 'id' => 'telefono', 'rules' => 'phone', 'required' => 'required']) }}
                    @if ($errors->first('telefono'))
                        <ul class="errors">
                            @foreach ($errors->get('telefono') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif
                </div>

                <div class="form-right">
                    {{ Form::label('email', 'Email', ['class' => 'label-input']) }}
                    {{ Form::text('email', $dati['email'], ['class' => 'input', 'id' => 'email', 'rules' => 'email', 'required' => 'required']) }}
                    @if ($errors->first('email'))
                        <ul class="errors">
                            @foreach ($errors->get('email') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif

                    {{ Form::label('password', 'Password') }}
                    {{ Form::password('password')}}
                    @if ($errors->first('password'))
                        <ul class="errors">
                            @foreach ($errors->get('password') as $message)
                                <li>{{ $message }}</li>
                            @endforeach
                        </ul>
                    @endif
                </div>
            </div>

            <button type="submit" class="btn">Modifica dati</button>
            <br>

            <div class="panel-buttons">
                <a class="btn btn-back" href="{{ route('hubUtente') }}">Torna indietro</a>
            </div>
        </div>
@endsection
